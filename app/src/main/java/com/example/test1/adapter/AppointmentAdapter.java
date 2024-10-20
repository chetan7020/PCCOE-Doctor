package com.example.test1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test1.R;
import com.example.test1.model.AppointmentModel;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

// ViewHolder class for AppointmentModel
class AppointmentViewHolder extends RecyclerView.ViewHolder {
    ShapeableImageView avatarImageView;
    TextView patientNameTextView;
    TextView appointmentStartTimeTextView;
    TextView appointmentEndTimeTextView;
    TextView appointmentDateTextView;
    TextView appointmentStatusTextView;
    TextView detailsTextView;

    public AppointmentViewHolder(@NonNull View itemView) {
        super(itemView);
        avatarImageView = itemView.findViewById(R.id.avatar_img);
        patientNameTextView = itemView.findViewById(R.id.tvPatientName);

        appointmentStartTimeTextView = itemView.findViewById(R.id.tvAppointmentStartTime);
        appointmentEndTimeTextView = itemView.findViewById(R.id.tvAppointmentEndTime);

        appointmentDateTextView = itemView.findViewById(R.id.tvAppointmentDate);
        appointmentStatusTextView = itemView.findViewById(R.id.tvAppointmentStatus);
        detailsTextView = itemView.findViewById(R.id.details);
    }
}

// Adapter class for AppointmentModel
public class AppointmentAdapter extends RecyclerView.Adapter<AppointmentViewHolder> {
    private List<AppointmentModel> appointmentList;

    public AppointmentAdapter(List<AppointmentModel> appointmentList) {
        this.appointmentList = appointmentList;
    }

    @NonNull
    @Override
    public AppointmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the custom item layout (appointment_layout.xml)
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.appointment_layout, parent, false);
        return new AppointmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppointmentViewHolder holder, int position) {
        // Bind data to the ViewHolder
        AppointmentModel appointment = appointmentList.get(position);

        holder.patientNameTextView.setText(appointment.getAppointmentPatientName());
        holder.appointmentStartTimeTextView.setText("Start Time: " + appointment.getAppointmentStartTime());
        holder.appointmentEndTimeTextView.setText("End Time: " + appointment.getAppointmentEndTime());
        holder.appointmentDateTextView.setText("Date: " + appointment.getAppointmentDate());
        holder.appointmentStatusTextView.setText("Status: " + appointment.getAppointmentStatus());

        // Add any additional logic to handle the 'Details' button or other interactions
        holder.detailsTextView.setOnClickListener(v -> {
            // Handle click event for 'Details' button
            // You can add an intent here to navigate to another screen or display a dialog
        });
    }

    @Override
    public int getItemCount() {
        return appointmentList.size();
    }
}
