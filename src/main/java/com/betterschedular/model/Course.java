package com.betterschedular.model;

import jakarta.persistence.*;

@Entity
public class Course {

    @Id //uid will be the primary key in the table
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Uid;

    String semesterName;
    String code;
    String section;
    Integer classNumber;
    String modality;
    String title;
    String ge;
    Float units;
    String type;
    String days;
    String times;
    String  Instructor;
    String location;
    String dates;
    Integer seats;

    public Course(String semesterName, String code, String section, Integer classNumber, String modality, String title, String ge, Float units, String type, String days, String times, String instructor, String location, String dates, Integer seats) {
        this.semesterName = semesterName;
        this.code = code;
        this.section = section;
        this.classNumber = classNumber;
        this.modality = modality;
        this.title = title;
        this.ge = ge;
        this.units = units;
        this.type = type;
        this.days = days;
        this.times = times;
        Instructor = instructor;
        this.location = location;
        this.dates = dates;
        this.seats = seats;
    }

    //no arg constructor for jpa
    public Course() {

    }

    @Override
    public String toString() {
        return "Course{" +
                "semesterName='" + semesterName + '\'' +
                ", code='" + code + '\'' +
                ", section='" + section + '\'' +
                ", classNumber=" + classNumber +
                ", modality='" + modality + '\'' +
                ", title='" + title + '\'' +
                ", ge='" + ge + '\'' +
                ", units=" + units +
                ", type='" + type + '\'' +
                ", days='" + days + '\'' +
                ", times='" + times + '\'' +
                ", Instructor='" + Instructor + '\'' +
                ", location='" + location + '\'' +
                ", dates='" + dates + '\'' +
                ", seats=" + seats +
                '}';
    }

    public Integer getUid() {
        return Uid;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Integer getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(Integer classNumber) {
        this.classNumber = classNumber;
    }

    public String getModality() {
        return modality;
    }

    public void setModality(String modality) {
        this.modality = modality;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGe() {
        return ge;
    }

    public void setGe(String ge) {
        this.ge = ge;
    }

    public Float getUnits() {
        return units;
    }

    public void setUnits(Float units) {
        this.units = units;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getInstructor() {
        return Instructor;
    }

    public void setInstructor(String instructor) {
        Instructor = instructor;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }
}
