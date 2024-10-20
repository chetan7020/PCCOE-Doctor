package com.example.test1.features.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.test1.R;
import com.example.test1.databinding.ActivityDashboardMainBinding;
import com.example.test1.databinding.ActivityProfileMainBinding;
import com.example.test1.features.profile.ProfileMainActivity;
import com.example.test1.model.DoctorModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class DashboardMainActivity extends AppCompatActivity {

    private ActivityDashboardMainBinding binding;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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