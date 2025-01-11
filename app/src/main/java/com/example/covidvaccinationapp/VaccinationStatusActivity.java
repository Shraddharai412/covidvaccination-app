package com.example.covidvaccinationapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class VaccinationStatusActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccination_status);

        TextView statusText = findViewById(R.id.statusText);
        Button checkStatusButton = findViewById(R.id.checkStatusButton);

        checkStatusButton.setOnClickListener(v -> {
            // Logic to fetch vaccination status
            statusText.setText("You are fully vaccinated!");
        });
    }
}
