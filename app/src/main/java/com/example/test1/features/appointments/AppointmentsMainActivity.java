package com.example.test1.features.appointments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.test1.databinding.ActivityMainAppointmentsBinding;
import com.google.firebase.firestore.FirebaseFirestore;

public class AppointmentsMainActivity extends AppCompatActivity {

    private ActivityMainAppointmentsBinding binding;

    private FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainAppointmentsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();

        setEventListeners();
    }

    private void init() {
        firebaseFirestore = FirebaseFirestore.getInstance();
    }

    private void setEventListeners() {
        binding.llUpcomingAppointments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        binding.llRequestedAppointments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        binding.llDeclinedAppointments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}