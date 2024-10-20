package com.example.test1.features.patients;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test1.BaseActivity;
import com.example.test1.adapter.ReportAdapter;
import com.example.test1.databinding.ActivityPatientDescriptionBinding;
import com.example.test1.model.ReportModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class PatientDescriptionActivity extends BaseActivity {

    private ActivityPatientDescriptionBinding binding;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth firebaseAuth;

    private String patientID;
    private String patientEmail;
    private String doctorEmail;
    private String patientName;
    private int patientAge;
    private String patientGender;
    private String patientBloodGroup;

    // List to store reports
    private List<ReportModel> reportList;
    private ReportAdapter reportAdapter;

    private String reportText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPatientDescriptionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialize patient data
        patientID = getIntent().getStringExtra("PATIENT_ID");
        patientEmail = getIntent().getStringExtra("PATIENT_EMAIL");
        doctorEmail = getIntent().getStringExtra("DOCTOR_EMAIL");
        patientName = getIntent().getStringExtra("PATIENT_NAME");
        patientAge = getIntent().getIntExtra("PATIENT_AGE", 0);
        patientGender = getIntent().getStringExtra("PATIENT_GENDER");
        patientBloodGroup = getIntent().getStringExtra("PATIENT_BLOOD_GROUP");

        // Initialize Firestore and RecyclerView
        init();

        // Load Reports from Firestore
        loadReportsFromFirestore();

        registerListener();
    }

    private void registerListener() {
        reportAdapter.setOnItemClickListener(new ReportAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                ReportModel selectedReport = reportList.get(position);

                Intent intent = new Intent(PatientDescriptionActivity.this, ViewReportActivity.class);
                intent.putExtra("reportModel", selectedReport);
                startActivity(intent);
            }
        });

    }

    private void init() {
        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();

        // Initialize report list and adapter
        reportList = new ArrayList<>();
        reportAdapter = new ReportAdapter(reportList);

        // Set up RecyclerView
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(reportAdapter);

        reportText = "";

        binding.tvPatientName.setText("Chetan Patil");
        binding.tvPatientAge.setText("22");
        binding.tvPatientGender.setText("Male");
        binding.tvPatientBloodGroup.setText("O+");
    }

    private void loadReportsFromFirestore() {
        // Fetch reports for the specific patient
        firebaseFirestore
                .collection("doctors")
                .document(firebaseAuth.getCurrentUser().getEmail())
                .collection("reports")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            // Clear the current list
                            reportList.clear();

                            // Loop through the results and populate the reportList
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                ReportModel report = document.toObject(ReportModel.class);

                                reportText = reportText + " " + report.toString();

                                reportList.add(report);
                            }

                            // Notify the adapter of data changes
                            reportAdapter.notifyDataSetChanged();
                        } else {
                            Log.d("Firestore", "Error getting documents: ", task.getException());
                        }
                    }
                });
    }
}