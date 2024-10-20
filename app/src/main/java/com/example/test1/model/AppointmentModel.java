package com.example.test1.model;

public class AppointmentModel {
    private String appointmentID;
    private String appointmentPatientName;
    private String appointmentDate;
    private String appointmentTime;
    private String appointmentStatus;

    public AppointmentModel() {
    }

    public String getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(String appointmentID) {
        this.appointmentID = appointmentID;
    }

    public String getAppointmentPatientName() {
        return appointmentPatientName;
    }

    public void setAppointmentPatientName(String appointmentPatientName) {
        this.appointmentPatientName = appointmentPatientName;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(String appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }
}
