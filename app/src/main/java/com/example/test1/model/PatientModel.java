package com.example.test1.model;

public class PatientModel {
    private String patientID;
    private String patientEmail;
    private String doctorEmail; // remove
    private String patientName;
    private int patientAge;
    private String patientGender;
    private String patientBloodGroup;

    public PatientModel() {
    }

    // Constructor
    public PatientModel(String patientID, String patientEmail, String doctorEmail,
                        String patientName, int patientAge, String patientGender,
                        String patientBloodGroup) {
        this.patientID = patientID;
        this.patientEmail = patientEmail;
        this.doctorEmail = doctorEmail;
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.patientGender = patientGender;
        this.patientBloodGroup = patientBloodGroup;
    }

    // Getters
    public String getPatientID() {
        return patientID;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public String getDoctorEmail() {
        return doctorEmail;
    }

    public String getPatientName() {
        return patientName;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public String getPatientBloodGroup() {
        return patientBloodGroup;
    }

    // Setters
    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public void setPatientBloodGroup(String patientBloodGroup) {
        this.patientBloodGroup = patientBloodGroup;
    }
}