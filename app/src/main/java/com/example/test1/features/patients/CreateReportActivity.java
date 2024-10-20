package com.example.test1.features.patients;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.test1.BaseActivity;
import com.example.test1.R;
import com.example.test1.databinding.ActivityCreateReportBinding;
import com.example.test1.databinding.ActivityPatientMainBinding;
import com.example.test1.model.ReportModel;
import com.example.test1.utils.Constant;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CreateReportActivity extends BaseActivity {
    private ActivityCreateReportBinding binding;

    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth firebaseAuth;

    private List<String> symptomsList = new ArrayList<>();
    private List<String> medicinesList = new ArrayList<>();
    private List<String> measuresList = new ArrayList<>();

    private String description;

    private String patientID;
    private String patientEmail;
    private String doctorEmail;
    private String patientName;
    private int patientAge;
    private String patientGender;
    private String patientBloodGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateReportBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
        setEventListeners();
    }

    private void init() {
        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();

        description = "";
        patientID = getIntent().getStringExtra("PATIENT_ID");
        patientEmail = getIntent().getStringExtra("PATIENT_EMAIL");
        doctorEmail = getIntent().getStringExtra("DOCTOR_EMAIL");
        patientName = getIntent().getStringExtra("PATIENT_NAME");
        patientAge = getIntent().getIntExtra("PATIENT_AGE", 0);
        patientGender = getIntent().getStringExtra("PATIENT_GENDER");
        patientBloodGroup = getIntent().getStringExtra("PATIENT_BLOOD_GROUP");    }

    private void setEventListeners() {
        binding.btnAddReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                description = binding.etDescription.getText().toString();
                String docEmail = firebaseAuth.getCurrentUser().getEmail();
                String dataString = "";


                ReportModel reportModel = new ReportModel(UUID.randomUUID().toString(), docEmail, patientEmail, description, dataString, symptomsList, medicinesList, measuresList);

                firebaseFirestore
                        .collection("doctors")
                        .document(firebaseAuth.getCurrentUser().getEmail())
                        .collection("reports")
                        .add(reportModel)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                firebaseFirestore
                                        .collection("patients")
                                        .document(patientEmail)
                                        .collection("reports")
                                        .document(reportModel.getReportID())
                                        .set(reportModel)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void unused) {
                                                Constant.showToast(CreateReportActivity.this, "Report Generated");
                                            }
                                        }).addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {

                                            }
                                        });

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });
            }
        });

        binding.ivAddSymptom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSymptoms();
            }
        });

        binding.ivAddMeasure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addMeasures();
            }
        });

        binding.ivAddMedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addMedicines();
            }
        });
    }

    private void addSymptoms() {
        String specialization = binding.etSymptoms.getText().toString().trim();

        if (!specialization.isEmpty()) {
            LayoutInflater inflater = LayoutInflater.from(this);
            LinearLayout specializationLayout = (LinearLayout) inflater.inflate(R.layout.specialization_layout, null);

            TextView tvSpecialization = specializationLayout.findViewById(R.id.tvSpecialization);
            ImageView tvDelete = specializationLayout.findViewById(R.id.tvDelete);

            tvSpecialization.setText(specialization);

            symptomsList.add(specialization);

            binding.glSymptoms.addView(specializationLayout);

            tvDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    removeSymptom(specializationLayout, specialization);
                }
            });

            binding.etSymptoms.setText("");
        }
    }

    private void removeSymptom(View symptomLayout, String symptom) {
        binding.glSymptoms.removeView(symptomLayout);
        symptomsList.remove(symptom);
    }

    public List<String> getAllSymptoms() {
        return new ArrayList<>(symptomsList);
    }


    private void addMedicines() {
        String specialization = binding.etMedicines.getText().toString().trim();

        if (!specialization.isEmpty()) {
            LayoutInflater inflater = LayoutInflater.from(this);
            LinearLayout specializationLayout = (LinearLayout) inflater.inflate(R.layout.specialization_layout, null);

            TextView tvSpecialization = specializationLayout.findViewById(R.id.tvSpecialization);
            ImageView tvDelete = specializationLayout.findViewById(R.id.tvDelete);

            tvSpecialization.setText(specialization);

            medicinesList.add(specialization);

            binding.glMedicines.addView(specializationLayout);

            tvDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    removeMedicine(specializationLayout, specialization);
                }
            });

            binding.etMedicines.setText("");
        }
    }

    private void removeMedicine(View medicineLayout, String medicine) {
        binding.glMedicines.removeView(medicineLayout);
        symptomsList.remove(medicine);
    }

    public List<String> getAllMedicine() {
        return new ArrayList<>(symptomsList);
    }


    private void addMeasures() {
        String measure = binding.etMeasures.getText().toString().trim();

        if (!measure.isEmpty()) {
            LayoutInflater inflater = LayoutInflater.from(this);
            LinearLayout specializationLayout = (LinearLayout) inflater.inflate(R.layout.specialization_layout, null);

            TextView tvSpecialization = specializationLayout.findViewById(R.id.tvSpecialization);
            ImageView tvDelete = specializationLayout.findViewById(R.id.tvDelete);

            tvSpecialization.setText(measure);

            measuresList.add(measure);

            binding.glMeasures.addView(specializationLayout);

            tvDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    removeMeasure(specializationLayout, measure);
                }
            });

            binding.etMeasures.setText("");
        }
    }

    private void removeMeasure(View measureLayout, String measure) {
        binding.glMeasures.removeView(measureLayout);
        measuresList.remove(measure);
    }

    public List<String> getAllMeasures() {
        return new ArrayList<>(measuresList);
    }

}