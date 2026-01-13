package com.example.databases;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class StudentCreateFragment extends Fragment {

    private EditText surnameField, nameField, birthdateField, departmentField, averageField;
    private Button addStudentButton;
    private DatabaseHelper databaseHelper;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databaseHelper = new DatabaseHelper(requireContext());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student_create, container, false);

        surnameField = view.findViewById(R.id.surnameField);
        nameField = view.findViewById(R.id.nameField);
        birthdateField = view.findViewById(R.id.birthdateField);
        departmentField = view.findViewById(R.id.departmentField);
        averageField = view.findViewById(R.id.averageField);
        addStudentButton = view.findViewById(R.id.addStudentButton);

        addStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStudent();
            }
        });

        return view;
    }

    private void addStudent() {
        String surname = surnameField.getText().toString().trim();
        String name = nameField.getText().toString().trim();
        String birthDate = birthdateField.getText().toString().trim();
        String department = departmentField.getText().toString().trim();
        String averageStr = averageField.getText().toString().trim();

        // Validate input
        if (TextUtils.isEmpty(surname) || TextUtils.isEmpty(name) || TextUtils.isEmpty(birthDate)
                || TextUtils.isEmpty(department) || TextUtils.isEmpty(averageStr)) {
            showToast("Please fill in all fields");
            return;
        }

        double average;
        try {
            average = Double.parseDouble(averageStr);
        } catch (NumberFormatException e) {
            showToast("Invalid average");
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        sdf.setLenient(false);
        try {
            sdf.parse(birthDate);
        } catch (ParseException e) {
            showToast("Invalid date format. Use yyyy-mm-dd");
            return;
        }

        // For now inserting placeholder image
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        boolean isSuccess = databaseHelper.addRecord(R.drawable.empty, surname, name, birthDate, department, average);
        db.close();

        if (isSuccess) {
            showToast("Student added successfully");
            surnameField.setText("");
            nameField.setText("");
            birthdateField.setText("");
            departmentField.setText("");
            averageField.setText("");
        } else {
            showToast("Failed to add student");
        }
    }

    private void showToast(String message) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show();
    }
}
