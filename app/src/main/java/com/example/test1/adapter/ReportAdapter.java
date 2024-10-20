package com.example.test1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test1.R;
import com.example.test1.model.ReportModel;

import java.util.List;

// ViewHolder class for ReportModel
class ReportViewHolder extends RecyclerView.ViewHolder {
    TextView tvID, tvDataString, tvPDFName;

    public ReportViewHolder(@NonNull View itemView, final ReportAdapter.OnItemClickListener listener) {
        super(itemView);
        // Initialize the TextViews
        tvID = itemView.findViewById(R.id.tvReportID);
        tvDataString = itemView.findViewById(R.id.tvDataString);
        tvPDFName = itemView.findViewById(R.id.tvPDFName);

        // Set OnClickListener for the itemView or any specific view
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position);
                    }
                }
            }
        });
    }
}

// Adapter class for ReportModel
public class ReportAdapter extends AbstractAdapter<ReportModel, ReportViewHolder> {

    private OnItemClickListener mListener;

    // Interface for handling click events
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    // Method to set the click listener from the activity
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    // Constructor to pass the list of reports
    public ReportAdapter(List<ReportModel> reportList) {
        super(reportList);
    }

    @NonNull
    @Override
    public ReportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for each report item (pdf_report_layout)
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pdf_report_layout, parent, false);
        return new ReportViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ReportViewHolder holder, int position) {
        // Get the current ReportModel item
        ReportModel report = getItem(position);

        // Bind data to the views
        holder.tvID.setText(report.getReportID());             // Bind report ID
        holder.tvDataString.setText(report.getDataString());   // Bind report data string
        holder.tvPDFName.setText(report.getDescription());     // Bind report description (PDF name)
    }
}
