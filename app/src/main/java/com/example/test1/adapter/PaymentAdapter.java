package com.example.test1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test1.R;
import com.example.test1.model.PaymentModel;

import java.util.List;

// ViewHolder class for PaymentModel
class PaymentViewHolder extends RecyclerView.ViewHolder {
    TextView emailTextView;
    TextView priceTextView;
    TextView statusTextView;

    public PaymentViewHolder(@NonNull View itemView) {
        super(itemView);
        emailTextView = itemView.findViewById(R.id.tvEmail);
        priceTextView = itemView.findViewById(R.id.tvPrice);
        statusTextView = itemView.findViewById(R.id.tvStatus);
    }
}

// Adapter class for PaymentModel
public class PaymentAdapter extends AbstractAdapter<PaymentModel, PaymentViewHolder> {

    public PaymentAdapter(List<PaymentModel> paymentList) {
        super(paymentList);
    }

    @NonNull
    @Override
    public PaymentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the payment_layout.xml
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.paymet_layout, parent, false);
        return new PaymentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentViewHolder holder, int position) {
        // Bind data to the ViewHolder
        PaymentModel payment = getItem(position);
        holder.emailTextView.setText("Email: " + payment.getPaymentPatient());
        holder.priceTextView.setText("Price: " + payment.getPaymentPrice());
        holder.statusTextView.setText("Status: " + payment.getPaymentStatus());
    }
}

