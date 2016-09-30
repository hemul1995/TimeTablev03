package com.example.dima.timetablev03;

/**
 * Created by Dima on 30.09.2016.
 */
public class Lesson {
    public String getKab() {
        return kab;
    }

    public void setKab(String kab) {
        this.kab = kab;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getTeachers() {
        return teachers;
    }

    public void setTeachers(String teachers) {
        this.teachers = teachers;
    }

    public String getTimeLesson() {
        return timeLesson;
    }

    public void setTimeLesson(String timeLesson) {
        this.timeLesson = timeLesson;
    }

    public Lesson(String kab, String lessonName, String teachers, String timeLesson) {
        this.kab = kab;
        this.lessonName = lessonName;
        this.teachers = teachers;
        this.timeLesson = timeLesson;
    }

    private String lessonName;
    private String timeLesson;
    private String kab;
    private String teachers;

}
