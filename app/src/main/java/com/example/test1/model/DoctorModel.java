package com.example.test1.model;

import java.io.Serializable;
import java.util.List;

public class DoctorModel  {
    private String docID;
    private String docName;
    private List<String> docSpecializations;
    private String docMobileNumber;
    private double docLat;
    private double docLang;
    private String docEmail;
    private int experience;
    private int patients;
    private int revenue;

    public DoctorModel() {}

    public DoctorModel(String docID, String docName, List<String> docSpecializations, String docMobileNumber, double docLat, double docLang, String docEmail) {
        this.docID = docID;
        this.docName = docName;
        this.docSpecializations = docSpecializations;
        this.docMobileNumber = docMobileNumber;
        this.docLat = docLat;
        this.docLang = docLang;
        this.docEmail = docEmail;
        this.experience = 0;
        this.patients = 0;
        this.revenue = 0;
    }

    public String getDocID() {
        return docID;
    }

    public void setDocID(String docID) {
        this.docID = docID;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public List<String> getDocSpecializations() {
        return docSpecializations;
    }

    public void setDocSpecializations(List<String> docSpecializations) {
        this.docSpecializations = docSpecializations;
    }

    public String getDocMobileNumber() {
        return docMobileNumber;
    }

    public void setDocMobileNumber(String docMobileNumber) {
        this.docMobileNumber = docMobileNumber;
    }

    public double getDocLat() {
        return docLat;
    }

    public void setDocLat(double docLat) {
        this.docLat = docLat;
    }

    public double getDocLang() {
        return docLang;
    }

    public void setDocLang(double docLang) {
        this.docLang = docLang;
    }

    public String getDocEmail() {
        return docEmail;
    }

    public void setDocEmail(String docEmail) {
        this.docEmail = docEmail;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getPatients() {
        return patients;
    }

    public void setPatients(int patients) {
        this.patients = patients;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }
}

