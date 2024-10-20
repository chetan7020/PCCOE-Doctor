package com.example.test1.model;

public class PaymentModel {
    private String paymentID;
    private String paymentPatient;
    private String paymentDoctor;
    private String paymentStatus;
    private int paymentPrice;

    // Constructor
    public PaymentModel() {
    }

    public PaymentModel(String paymentID, String paymentPatient, String paymentDoctor, String paymentStatus, int paymentPrice) {
        this.paymentID = paymentID;
        this.paymentPatient = paymentPatient;
        this.paymentDoctor = paymentDoctor;
        this.paymentStatus = paymentStatus;
        this.paymentPrice = paymentPrice;
    }

    // Getters
    public String getPaymentID() {
        return paymentID;
    }

    public String getPaymentPatient() {
        return paymentPatient;
    }

    public String getPaymentDoctor() {
        return paymentDoctor;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public int getPaymentPrice() {
        return paymentPrice;
    }

    // Setters
    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public void setPaymentPatient(String paymentPatient) {
        this.paymentPatient = paymentPatient;
    }

    public void setPaymentDoctor(String paymentDoctor) {
        this.paymentDoctor = paymentDoctor;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setPaymentPrice(int paymentPrice) {
        this.paymentPrice = paymentPrice;
    }
}
