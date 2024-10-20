package com.example.test1.features.patients;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.test1.BaseActivity;
import com.example.test1.R;
import com.example.test1.databinding.ActivityPatientDescriptionBinding;
import com.example.test1.databinding.ActivityProfileMainBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class PatientDescriptionActivity extends BaseActivity {

    private ActivityPatientDescriptionBinding binding;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth firebaseAuth;

    String patientID;
    String patientEmail;
    String doctorEmail;
    String patientName;
    int patientAge;
    String patientGender;
    String patientBloodGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPatientDescriptionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        patientID = getIntent().getStringExtra("PATIENT_ID");
        patientEmail = getIntent().getStringExtra("PATIENT_EMAIL");
        doctorEmail = getIntent().getStringExtra("DOCTOR_EMAIL");
        patientName = getIntent().getStringExtra("PATIENT_NAME");
        patientAge = getIntent().getIntExtra("PATIENT_AGE", 0);
        patientGender = getIntent().getStringExtra("PATIENT_GENDER");
        patientBloodGroup = getIntent().getStringExtra("PATIENT_BLOOD_GROUP");

        init();
        setEventListeners();
    }

    private void init() {
        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
    }

    private void setEventListeners() {
    }
}