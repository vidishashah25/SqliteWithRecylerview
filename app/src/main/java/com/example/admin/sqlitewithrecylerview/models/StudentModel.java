package com.example.admin.sqlitewithrecylerview.models;

/**
 * Created by Admin on 2/9/2017.
 */

//StudentModel

public class StudentModel {

    int studentID;
    String studentName;
    String studentEmail;

    public StudentModel(int studentID, String studentName, String studentEmail) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }
}
