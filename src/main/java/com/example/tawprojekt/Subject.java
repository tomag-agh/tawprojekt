package com.example.tawprojekt;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@JsonSerialize
@Data
public class Subject {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("nazwa")
    private String name;

    @JsonProperty("punkty")
    private Integer points;

    @JsonProperty("nrsali")
    private Integer room;

    @JsonProperty("egzamin")
    private Boolean exam;

/* ALt_Insert dodajemy getter i Setter*/

    /*
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    */

}
