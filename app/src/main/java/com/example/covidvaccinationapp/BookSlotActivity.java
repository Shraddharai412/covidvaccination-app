package com.example.covidvaccinationapp;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookSlotActivity extends AppCompatActivity {

    private Button buttonPickDate, buttonBookSlot;
    private TextView textViewSelectedDate;
    private ListView listViewSlots;

    private String selectedDate = null;
    private String selectedSlot = null;

    private Map<String, List<String>> slotsMap; // Mock data for available slots

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_slot);

        buttonPickDate = findViewById(R.id.buttonPickDate);
        textViewSelectedDate = findViewById(R.id.textViewSelectedDate);
        listViewSlots = findViewById(R.id.listViewSlots);
        buttonBookSlot = findViewById(R.id.buttonBookSlot);

        initializeMockSlots();

        buttonPickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePicker();
            }
        });

        listViewSlots.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                selectedSlot = (String) adapterView.getItemAtPosition(position);
                buttonBookSlot.setVisibility(View.VISIBLE);
                Toast.makeText(BookSlotActivity.this, "Selected Slot: " + selectedSlot, Toast.LENGTH_SHORT).show();
            }
        });

        buttonBookSlot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedSlot != null && selectedDate != null) {
                    Toast.makeText(BookSlotActivity.this, "Slot booked on " + selectedDate + " at " + selectedSlot, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(BookSlotActivity.this, "Please select a slot and date!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void showDatePicker() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                selectedDate = day + "/" + (month + 1) + "/" + year;
                textViewSelectedDate.setText("Selected Date: " + selectedDate);
                loadSlotsForDate(selectedDate);
            }
        }, year, month, day);

        datePickerDialog.show();
    }

    private void initializeMockSlots() {
        slotsMap = new HashMap<>();
        slotsMap.put("1/1/2025", List.of("10:00 AM", "11:00 AM", "2:00 PM"));
        slotsMap.put("2/1/2025", List.of("9:00 AM", "12:00 PM", "4:00 PM"));
        slotsMap.put("3/1/2025", List.of("8:00 AM", "1:00 PM", "3:00 PM"));
    }

    private void loadSlotsForDate(String date) {
        List<String> slots = slotsMap.get(date);
        if (slots != null && !slots.isEmpty()) {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, slots);
            listViewSlots.setAdapter(adapter);
        } else {
            listViewSlots.setAdapter(null);
            Toast.makeText(this, "No slots available for " + date, Toast.LENGTH_SHORT).show();
        }
    }
}
