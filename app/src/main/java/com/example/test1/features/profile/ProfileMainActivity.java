package com.example.test1.features.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.test1.databinding.ActivityProfileMainBinding;
import com.example.test1.model.DoctorModel;
import com.example.test1.utils.Constant;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class ProfileMainActivity extends AppCompatActivity {

    private ActivityProfileMainBinding binding;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
        setEventListeners();
        fetchDoctorData();
    }

    private void init() {
        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
    }

    private void setEventListeners() {
        binding.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Constant.showToast(ProfileMainActivity.this, "go to update");
            }
        });

        binding.btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Constant.showToast(ProfileMainActivity.this, "Logged Out");

            }
        });
    }


    private void fetchDoctorData() {
        String userEmail = firebaseAuth.getCurrentUser() != null ? firebaseAuth.getCurrentUser().getEmail() : null;

        if (userEmail != null) {
            firebaseFirestore.collection("doctors") // Replace with your Firestore collection name
                    .document(userEmail)
                    .get()
                    .addOnSuccessListener(documentSnapshot -> {
                        if (documentSnapshot.exists()) {
                            // Map the document to DoctorModel
                            DoctorModel doctor = documentSnapshot.toObject(DoctorModel.class);
                            if (doctor != null) {
                                updateUIWithDoctorData(doctor);
                            }
                        } else {
                            Toast.makeText(ProfileMainActivity.this, "Doctor not found", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(e -> {
                        Toast.makeText(ProfileMainActivity.this, "Error fetching data", Toast.LENGTH_SHORT).show();
                    });
        } else {
            Toast.makeText(this, "User not logged in", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateUIWithDoctorData(DoctorModel doctor) {
        binding.tvDocName.setText(doctor.getDocName());
        binding.tvDocMobileNumber.setText(doctor.getDocMobileNumber());
        binding.tvDocAddress.setText(getAddress(doctor.getDocLat(), doctor.getDocLang()));
        binding.tvDocEmail.setText(firebaseAuth.getCurrentUser().getEmail());
    }

    private String getAddress(double docLat, double docLang) {
        String address = "";


        return address;
    }
}
