package com.example.databases;

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

public class StudentEditFragment extends Fragment {
    private EditText nameField, surnameField, departmentField, birthdateField, averageField;
    private Button saveButton;
    private Student student;
    private DatabaseHelper databaseHelper;

    public StudentEditFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student_edit, container, false);

        nameField = view.findViewById(R.id.nameField);
        surnameField = view.findViewById(R.id.surnameField);
        departmentField = view.findViewById(R.id.departmentField);
        birthdateField = view.findViewById(R.id.birthdateField);
        averageField = view.findViewById(R.id.averageField);
        saveButton = view.findViewById(R.id.updateStudentButton);
        databaseHelper = new DatabaseHelper(getContext());

        if (getArguments() != null) {
            student = (Student) getArguments().getSerializable("student");
            if (student != null) {
                nameField.setText(student.name);
                surnameField.setText(student.surname);
                departmentField.setText(student.department);
                birthdateField.setText(student.birthDate);
                averageField.setText(String.valueOf(student.average));
            }
        }

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { updateStudent();}
        });

        return view;
    }

    private void updateStudent() {
        int id = student.id;
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
        boolean isSuccess = databaseHelper.updateRecord(id, surname, name, birthDate, department, average);
        db.close();

        if (isSuccess) {
            showToast("Student updated successfully");
        } else {
            showToast("Failed to update student");
        }
    }

    private void showToast(String message) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show();
    }
}