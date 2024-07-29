package com.betterschedular.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Instructor {

    @Id //uid will be the primary key in the table
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Uid;

    String name;
    String department;
    Double quality;
    Double difficulty;
    String href;

    public Instructor(String name, String department, Double quality, Double difficulty, String href) {
        this.name = name;
        this.department = department;
        this.quality = quality;
        this.difficulty = difficulty;
        this.href = href;
    }

    //no arg constructor for jpa
    public Instructor() {

    }

    @Override
    public String toString() {
        return "Instructor{" +
                "Uid=" + Uid +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", quality=" + quality +
                ", difficulty=" + difficulty +
                ", href='" + href + '\'' +
                '}';
    }

    public Integer getUid() {
        return Uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getQuality() {
        return quality;
    }

    public void setQuality(Double quality) {
        this.quality = quality;
    }

    public Double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Double difficulty) {
        this.difficulty = difficulty;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
