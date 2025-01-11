package com.example.covidvaccinationapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class UserDashboardActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        Button bookSlotButton = findViewById(R.id.bookSlotButton);
        Button viewStatusButton = findViewById(R.id.viewStatusButton);

        bookSlotButton.setOnClickListener(v -> {
            startActivity(new Intent(UserDashboardActivity.this, BookSlotActivity.class));
        });

        viewStatusButton.setOnClickListener(v -> {
            startActivity(new Intent(UserDashboardActivity.this, VaccinationStatusActivity.class));
        });
    }
}
