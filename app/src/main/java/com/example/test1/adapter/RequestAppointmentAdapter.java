package com.example.test1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test1.R;
import com.example.test1.model.AppointmentModel;

import java.util.List;

class RequestAppointmentViewHolder extends RecyclerView.ViewHolder {
    TextView patientNameTextView;
    TextView dateTextView;
    TextView startTimeTextView;
    TextView endTimeTextView;
    TextView statusTextView;
    Button acceptButton;
    Button declineButton;

    public RequestAppointmentViewHolder(@NonNull View itemView) {
        super(itemView);
        patientNameTextView = itemView.findViewById(R.id.tvPatientName);
        dateTextView = itemView.findViewById(R.id.tvAppointmentDate);
        startTimeTextView = itemView.findViewById(R.id.tvAppointmentStartTime);
        endTimeTextView = itemView.findViewById(R.id.tvAppointmentEndTime);
        statusTextView = itemView.findViewById(R.id.tvAppointmentStatus);
        acceptButton = itemView.findViewById(R.id.btnAcceptAppointment);
        declineButton = itemView.findViewById(R.id.btnDeclineAppointment);
    }
}

// Adapter class for AppointmentModel
public class RequestAppointmentAdapter extends RecyclerView.Adapter<RequestAppointmentViewHolder> {

    private final List<AppointmentModel> appointmentList;
    private final OnAppointmentActionListener actionListener;

    public RequestAppointmentAdapter(List<AppointmentModel> appointmentList, OnAppointmentActionListener actionListener) {
        this.appointmentList = appointmentList;
        this.actionListener = actionListener;
    }

    @NonNull
    @Override
    public RequestAppointmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the custom item layout
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.requested_appointment_layout, parent, false);
        return new RequestAppointmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RequestAppointmentViewHolder holder, int position) {
        // Bind data to the ViewHolder
        AppointmentModel appointment = appointmentList.get(position);
        holder.patientNameTextView.setText(appointment.getAppointmentPatientName());
        holder.dateTextView.setText(appointment.getAppointmentDate());
        holder.startTimeTextView.setText(appointment.getAppointmentStartTime());
        holder.endTimeTextView.setText(appointment.getAppointmentEndTime());
        holder.statusTextView.setText(appointment.getAppointmentStatus());

        // Handle accept button click
        holder.acceptButton.setOnClickListener(v -> {
            if (actionListener != null) {
                actionListener.onAccept(appointment);
            }
        });

        // Handle decline button click
        holder.declineButton.setOnClickListener(v -> {
            if (actionListener != null) {
                actionListener.onDecline(appointment);
            }
        });
    }

    @Override
    public int getItemCount() {
        return appointmentList.size();
    }

    // Interface for handling actions on the appointment (accept/decline)
    public interface OnAppointmentActionListener {
        void onAccept(AppointmentModel appointment);

        void onDecline(AppointmentModel appointment);
    }
}
