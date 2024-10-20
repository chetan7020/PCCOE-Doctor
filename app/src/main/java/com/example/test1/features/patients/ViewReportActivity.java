package com.example.test1.features.patients;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.test1.R;
import com.example.test1.databinding.ActivityCreateReportBinding;
import com.example.test1.databinding.ActivityViewReportBinding;
import com.example.test1.model.ReportModel;
import com.example.test1.utils.Constant;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class ViewReportActivity extends AppCompatActivity {

    private ActivityViewReportBinding binding;

    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth firebaseAuth;

    private ReportModel report;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewReportBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        report = (ReportModel) intent.getSerializableExtra("reportModel");


        init();
        setEventListeners();
        setData();
    }

    private void init() {
        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
    }

    private void setEventListeners() {
    }

    private void setData(){
        binding.tvDocEmail.setText(report.getDocID());
        binding.tvDescription.setText(report.getDescription());
        setSymptom();
        setMedicine();
        setMeasures();
    }

    private void setSymptom() {
        List<String> specializations = report.getSymptoms();

        LinearLayout glSpecializations = findViewById(R.id.glSymptoms);
        glSpecializations.removeAllViews(); // Clear existing views if any

        for (String specialization : specializations) {
            View cardView = LayoutInflater.from(this).inflate(R.layout.specialization_normal_layout, glSpecializations, false);

            TextView textView = cardView.findViewById(R.id.tvSpecialization); // Assuming the TextView has this id
            textView.setText(specialization);

            glSpecializations.addView(cardView);
        }
    }

    private void setMedicine() {
        List<String> specializations = report.getMedicines();

        LinearLayout glSpecializations = findViewById(R.id.glMedicines);
        glSpecializations.removeAllViews(); // Clear existing views if any

        for (String specialization : specializations) {
            View cardView = LayoutInflater.from(this).inflate(R.layout.specialization_normal_layout, glSpecializations, false);

            TextView textView = cardView.findViewById(R.id.tvSpecialization); // Assuming the TextView has this id
            textView.setText(specialization);

            glSpecializations.addView(cardView);
        }
    }

    private void setMeasures() {
        List<String> specializations = report.getMeasures();

        LinearLayout glSpecializations = findViewById(R.id.glMeasures);
        glSpecializations.removeAllViews(); // Clear existing views if any

        for (String specialization : specializations) {
            View cardView = LayoutInflater.from(this).inflate(R.layout.specialization_normal_layout, glSpecializations, false);

            TextView textView = cardView.findViewById(R.id.tvSpecialization); // Assuming the TextView has this id
            textView.setText(specialization);

            glSpecializations.addView(cardView);
        }
    }



}