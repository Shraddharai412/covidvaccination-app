package com.example.covidvaccinationapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextUsername, editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = findViewById(R.id.username);
        editTextPassword = findViewById(R.id.password);
        buttonLogin = findViewById(R.id.loginButton);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editTextUsername.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else if (username.equals("admin") && password.equals("admin")) {
                    // Redirect to Admin Dashboard
                    Intent intent = new Intent(LoginActivity.this, AdminDashboardActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    // Redirect to User Dashboard
                    Intent intent = new Intent(LoginActivity.this, UserDashboardActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
