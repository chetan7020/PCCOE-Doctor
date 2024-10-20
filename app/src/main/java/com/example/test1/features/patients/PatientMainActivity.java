package com.example.test1.features.patients;

import android.os.Bundle;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.appcompat.app.AppCompatActivity;

import com.example.test1.BaseActivity;
import com.example.test1.R;
import com.example.test1.adapter.PatientAdapter;
import com.example.test1.databinding.ActivityPatientMainBinding;
import com.example.test1.model.PatientModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class PatientMainActivity extends BaseActivity {

    private ActivityPatientMainBinding binding;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPatientMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
        setEventListeners();
    }

    private void init() {
        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
    }

    private void setEventListeners() {
        fetchPatientsFromFirestore();
    }

    private void fetchPatientsFromFirestore() {
        firebaseFirestore.collection("patients") // Change to your Firestore collection name
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        List<PatientModel> patientList = new ArrayList<>();
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            PatientModel patient = document.toObject(PatientModel.class);
                            patientList.add(patient);
                        }
                        setupRecyclerView(patientList);
                    } else {
                        Log.d("PatientMainActivity", "Error getting documents: ", task.getException());
                    }
                });
    }

    private void setupRecyclerView(List<PatientModel> patientList) {
        PatientAdapter patientAdapter = new PatientAdapter(patientList);
        binding.recyclerView.setAdapter(patientAdapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
