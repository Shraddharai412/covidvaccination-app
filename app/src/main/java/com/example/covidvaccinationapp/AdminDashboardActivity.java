package com.example.covidvaccinationapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class AdminDashboardActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        Button postSlotsButton = findViewById(R.id.postSlotsButton);
        Button viewUserRecordsButton = findViewById(R.id.viewUserRecordsButton);

        postSlotsButton.setOnClickListener(v -> {
            // Navigate to PostSlotsActivity
            startActivity(new Intent(AdminDashboardActivity.this, PostSlotsActivity.class));
        });

        viewUserRecordsButton.setOnClickListener(v -> {
            // Navigate to UserRecordsActivity (not implemented in this flow)
        });
    }
}
