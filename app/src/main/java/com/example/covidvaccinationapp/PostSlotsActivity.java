package com.example.covidvaccinationapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PostSlotsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_slots);

        EditText slotDate = findViewById(R.id.slotDate);
        EditText slotTime = findViewById(R.id.slotTime);
        EditText slotCapacity = findViewById(R.id.slotCapacity);
        Button postButton = findViewById(R.id.postButton);

        postButton.setOnClickListener(v -> {
            // Logic to post slots
            String date = slotDate.getText().toString();
            String time = slotTime.getText().toString();
            String capacity = slotCapacity.getText().toString();

            if (date.isEmpty() || time.isEmpty() || capacity.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Slot posted successfully!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
