package com.example.covidvaccinationapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button registerButton = findViewById(R.id.registerButton);

        registerButton.setOnClickListener(v -> {
            // Registration logic here
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        });
    }
}
