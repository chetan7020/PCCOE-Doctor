package com.example.test1.features.appointments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.test1.R;
import com.example.test1.adapter.RequestAppointmentAdapter;
import com.example.test1.databinding.ActivityRequestedAppointmentBinding;
import com.example.test1.model.AppointmentModel;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class RequestedAppointmentActivity extends AppCompatActivity implements RequestAppointmentAdapter.OnAppointmentActionListener {

    private ActivityRequestedAppointmentBinding binding;
    private FirebaseFirestore firebaseFirestore;
    private RequestAppointmentAdapter adapter;
    private List<AppointmentModel> appointmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRequestedAppointmentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
        loadAppointmentsFromFirestore();
    }

    // Initialize Firestore and RecyclerView
    private void init() {
        firebaseFirestore = FirebaseFirestore.getInstance();
        appointmentList = new ArrayList<>();

        // Set up RecyclerView with adapter
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RequestAppointmentAdapter(appointmentList, this);
        binding.recyclerView.setAdapter(adapter);
    }

    // Load data from Firestore and notify the adapter
    private void loadAppointmentsFromFirestore() {
        firebaseFirestore.collection("appointments")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        QuerySnapshot querySnapshot = task.getResult();
                        if (querySnapshot != null) {
                            for (QueryDocumentSnapshot document : querySnapshot) {
                                AppointmentModel appointment = document.toObject(AppointmentModel.class);
                                appointmentList.add(appointment); // Add to the list
                            }
                            adapter.notifyDataSetChanged(); // Notify adapter of data change
                        }
                    } else {
                        Log.e("FirestoreError", "Error getting documents: ", task.getException());
                        Toast.makeText(this, "Error loading appointments", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void onAccept(AppointmentModel appointment) {
        Toast.makeText(this, "Appointment accepted: " + appointment.getAppointmentPatientName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDecline(AppointmentModel appointment) {
        Toast.makeText(this, "Appointment declined: " + appointment.getAppointmentPatientName(), Toast.LENGTH_SHORT).show();
    }
}
