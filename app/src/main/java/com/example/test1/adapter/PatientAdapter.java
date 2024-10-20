package com.example.test1.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test1.R;
import com.example.test1.features.patients.PatientDescriptionActivity;
import com.example.test1.model.PatientModel;

import java.util.List;

class PatientViewHolder extends RecyclerView.ViewHolder {
    TextView patientNameTextView;
    TextView patientAgeTextView;
    TextView patientGenderTextView;
    TextView patientBloodGroupTextView;

    public PatientViewHolder(@NonNull View itemView) {
        super(itemView);
        patientNameTextView = itemView.findViewById(R.id.tvPatientName);
        patientAgeTextView = itemView.findViewById(R.id.tvPatientAge);
        patientGenderTextView = itemView.findViewById(R.id.tvPatientGender);
        patientBloodGroupTextView = itemView.findViewById(R.id.tvPatientBloodGroup);
    }
}

public class PatientAdapter extends AbstractAdapter<PatientModel, PatientViewHolder> {

    public PatientAdapter(List<PatientModel> patientList) {
        super(patientList);
    }

    @NonNull
    @Override
    public PatientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.patient_layout, parent, false); // Ensure to use the correct layout name here
        return new PatientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PatientViewHolder holder, int position) {
        PatientModel patient = getItem(position);
        holder.patientNameTextView.setText(patient.getPatientName());
        holder.patientAgeTextView.setText(String.valueOf(patient.getPatientAge()));
        holder.patientGenderTextView.setText(patient.getPatientGender());
        holder.patientBloodGroupTextView.setText(patient.getPatientBloodGroup());

        // Set OnClickListener for the CardView
        holder.itemView.setOnClickListener(v -> {
            Context context = holder.itemView.getContext();
            Intent intent = new Intent(context, PatientDescriptionActivity.class); // Replace with your detail activity
            intent.putExtra("PATIENT_ID", patient.getPatientID());
            intent.putExtra("PATIENT_EMAIL", patient.getPatientEmail());
            intent.putExtra("DOCTOR_EMAIL", patient.getDoctorEmail());
            intent.putExtra("PATIENT_NAME", patient.getPatientName());
            intent.putExtra("PATIENT_AGE", patient.getPatientAge());
            intent.putExtra("PATIENT_GENDER", patient.getPatientGender());
            intent.putExtra("PATIENT_BLOOD_GROUP", patient.getPatientBloodGroup());
            context.startActivity(intent);
        });
    }
}
