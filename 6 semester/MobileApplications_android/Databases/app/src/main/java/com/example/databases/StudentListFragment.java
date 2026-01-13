package com.example.databases;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class StudentListFragment extends Fragment {


    public StudentListFragment() {
        // Required empty public constructor
    }

    ImageView imageView;
    Student currentStudent;
    ListView listView;
    TextView studentData;
    RadioGroup radioGroup;
    BaseAdapter adapter;

    DatabaseHelper db;
    SQLiteDatabase database;

    Button clearDatabaseButton;
    Button seedDatabaseButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student_list, container, false);

        db = new DatabaseHelper(getContext());
        database = db.getWritableDatabase();

        imageView = view.findViewById(R.id.imageView);
        adapter = new StudentView(getContext(), Student.students, new StudentView.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                currentStudent = Student.students.get(position);
                imageView.setImageResource(currentStudent.image);

                String personalData = "Student data:\n" +
                        currentStudent.name + " " + currentStudent.surname + "\n " +
                        currentStudent.birthDate + " - " + currentStudent.getAge() + " years old,\n" +
                        "Department: " + currentStudent.department + "\n"
                        + "Average: " + currentStudent.average;
                studentData.setText(personalData);
            }
        });

        listView = view.findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        studentData = view.findViewById(R.id.studentDescription);

        radioGroup = view.findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(changeOrder);

        seedDatabaseButton = view.findViewById(R.id.seedDatabase);
        seedDatabaseButton.setOnClickListener(seedDatabase);

        clearDatabaseButton = view.findViewById(R.id.clearDatabase);
        clearDatabaseButton.setOnClickListener(clearDatabase);

        loadFromDatabase();

        return view;
    }

    OnClickListener seedDatabase = new OnClickListener() {
        @Override
        public void onClick(View view) {
            if (db.isDatabaseEmpty()) {
                db.addRecord(R.drawable.facet1, "Antczak", "Stanisław", "1999-09-14", "Mechaniczny", 4.13);
                db.addRecord(R.drawable.facet2, "Antkiewicz", "Janusz", "2000-09-14", "Mechaniczny", 4.19);
                db.addRecord(R.drawable.facet3, "Bartnik", "Paweł", "2000-07-14", "Nawigacyjny", 4.13);
                db.addRecord(R.drawable.facet4, "Bartkowiak", "Adam", "2001-09-14","Elektryczny", 3.13);
                db.addRecord(R.drawable.facet5, "Zagórski", "Paweł", "2000-03-11","Elektryczny", 3.99);
                db.addRecord(R.drawable.facet6, "Zawadzki", "Piotr", "2000-12-17","PiT", 4.01);
                db.addRecord(R.drawable.facet7, "Kowalski", "Bartosz", "2000-06-25","Nawigacyjny", 3.99);
                db.addRecord(R.drawable.facet10, "Janowski", "Bartosz", "2000-01-12","Elektryczny", 3.29);
                db.addRecord(R.drawable.facet8, "Żurawski", "Mikołaj", "2001-04-14","PiT", 4.89);
                db.addRecord(R.drawable.facet9, "Filipiak", "Paweł", "2000-09-24","PiT", 3.99);
                db.addRecord(R.drawable.facet11, "Gutkowski", "Zdzisław", "2000-07-29","Nawigacyjny", 4.05);
                Toast.makeText(getContext(), "Database seeded", Toast.LENGTH_SHORT).show();
                loadFromDatabase();
            } else {
                Toast.makeText(getContext(), "Database is not empty - values don't get seeded", Toast.LENGTH_SHORT).show();
            }
        }
    };

    OnClickListener clearDatabase = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Cursor cursor = db.selectStudents();

            Student.students.clear();

            if (cursor.getCount() == 0) {
                Toast.makeText(getContext(), "Database is already empty", Toast.LENGTH_SHORT).show();

                return;
            }

            if (cursor != null) {
                cursor.moveToFirst();
                do {
                    int id = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
                    db.removeRecord(id);
                } while (cursor.moveToNext());
                cursor.close();
                Toast.makeText(getContext(), "Cleared the table students", Toast.LENGTH_SHORT).show();
            }

            loadFromDatabase();
        }
    };

    public void loadFromDatabase() {
        Cursor cursor = db.selectStudents();

        Student.students.clear();

        if (cursor.getCount() == 0) {
            adapter.notifyDataSetChanged();
            return;
        }

        if (cursor != null) {
            cursor.moveToFirst();
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
                int image = cursor.getInt(cursor.getColumnIndexOrThrow("ZDJECIE"));
                String surname = cursor.getString(cursor.getColumnIndexOrThrow("NAZWISKO"));
                String name = cursor.getString(cursor.getColumnIndexOrThrow("IMIE"));
                String department = cursor.getString(cursor.getColumnIndexOrThrow("WYDZIAL"));
                String birthDate = cursor.getString(cursor.getColumnIndexOrThrow("DATAUR"));
                double average = cursor.getDouble(cursor.getColumnIndexOrThrow("SREDNIA"));

                Student student = new Student(id, name, surname, department, birthDate, average, image);
            } while (cursor.moveToNext());
            cursor.close();
        }
        adapter.notifyDataSetChanged();
    }
    RadioGroup.OnCheckedChangeListener changeOrder = new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {

            RadioButton checkedRadioButton = group.findViewById(checkedId);
            boolean isChecked = checkedRadioButton.isChecked();

            if (isChecked) {

                int id = group.getCheckedRadioButtonId();

                if(id == R.id.sortByName) {
                    Student.students.sort(Student.compareByName);
                } else if (id == R.id.sortByAverage) {
                    Student.students.sort(Student.compareByAverage);
                }

                adapter.notifyDataSetChanged();
            }

        }
    };

}