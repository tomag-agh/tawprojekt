package com.example.tawprojekt;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class SubjectDatabase {

    private List<Subject> subjectList = new ArrayList<>();
    private int subjectCounter = 1;

    public void addSubject(Subject element) {
        element.setId(subjectCounter);
        subjectList.add(element);
        subjectCounter++;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public List<Subject> getSubjectList(String name, Integer points, Integer room, Boolean exam) {
        if (points == null && name == null && room == null && exam == null) {
            return subjectList;
        }

        List<Subject> filteredSubjects = new ArrayList<>();
        for (Subject element : subjectList) {
            if ((name == null || element.getName().equals(name)) &&
                    (points == null || element.getPoints().equals(points)) &&
                    (room == null || element.getRoom().equals(room)) &&
                    (exam == null || element.getExam().equals(exam))) {
                filteredSubjects.add(element);
            }
        }

        return filteredSubjects;
    }

    public void deleteAll() {
        subjectList.clear();
    }

    public Subject getSubjectById(Integer id) {
        for (Subject element : subjectList) {
            if (element.getId().equals(id)) {
                return element;
            }
        }
        return null;
    }

    public void deleteById(Integer id) {
        Subject subjectToDelete = null;
        for (Subject element : subjectList) {
            if (element.getId().equals(id)) {
                subjectToDelete = element;
                break;
            }
        }
        if (subjectToDelete != null) {
            subjectList.remove(subjectToDelete);
        }
    }
}
