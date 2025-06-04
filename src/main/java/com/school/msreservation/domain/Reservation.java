package com.school.msreservation.domain;

import java.util.UUID;

public class Reservation {
    private UUID courseId;
    private String courseName;
    private UUID studentId;
    private String studentName;
    private UUID teacherId;
    private String teacherNome;

    public Reservation() {
    }

    public Reservation(UUID courseId, String courseName, UUID studentId, String studentName, UUID teacherId, String teacherNome) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.studentId = studentId;
        this.studentName = studentName;
        this.teacherId = teacherId;
        this.teacherNome = teacherNome;
    }

    public UUID getCourseId() {
        return courseId;
    }

    public void setCourseId(UUID courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public UUID getStudentId() {
        return studentId;
    }

    public void setStudentId(UUID studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public UUID getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(UUID teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherNome() {
        return teacherNome;
    }

    public void setTeacherNome(String teacherNome) {
        this.teacherNome = teacherNome;
    }

    @Override
    public String toString() {
        return "Reserve{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", teacherId=" + teacherId +
                ", teacherNome='" + teacherNome + '\'' +
                '}';
    }
}


