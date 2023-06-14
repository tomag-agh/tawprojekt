package com.example.tawprojekt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("API")
public class SubjectAPI {
    @Autowired
    private SubjectDatabase subjectDatabase;

    @GetMapping("test")
    public String testAPI1() {
        return "TEST";
    }

    @PostMapping(value = "subjects", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void addNewSubject(@RequestBody Subject element) {
        subjectDatabase.addSubject(element);
    }

    @GetMapping(value = "subjects", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Subject> getSubjects(
            @Nullable @RequestParam("name") String name,
            @Nullable @RequestParam("points") Integer points,
            @Nullable @RequestParam("room") Integer room,
            @Nullable @RequestParam("exam") Boolean exam
    ) {
        return subjectDatabase.getSubjectList(name, points, room, exam);
    }

    @GetMapping(value = "subjects/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getSubjectById(@PathVariable("id") Integer id) {
        Subject subject = subjectDatabase.getSubjectById(id);
        if (subject == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(subject);
        }
    }

    @DeleteMapping(value = "subjects")
    public void deleteSubjects() {
        subjectDatabase.deleteAll();
    }

    @DeleteMapping(value = "subjects/{id}")
    public void deleteSubject(@PathVariable("id") Integer id) {
        subjectDatabase.deleteById(id);
    }
}
