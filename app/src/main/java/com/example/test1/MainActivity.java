package com.example.test1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.test1.auth.LoginActivity;
import com.example.test1.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding binding;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
        setEventListeners();
    }

    private void init() {
        firebaseAuth = FirebaseAuth.getInstance();
    }

    private void setEventListeners() {
        binding.llPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        binding.llDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        binding.llAppointments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        binding.llTransactions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        binding.llProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}
