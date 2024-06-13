package com.example.databases;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Student currentStudent;
    ListView listView;
    TextView studentData;
    RadioGroup radioGroup;
    BaseAdapter adapter;

    DatabaseHelper db;
    SQLiteDatabase database;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;

    /*
    AdapterView.OnItemClickListener listListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Log.v("MainActivity", "onItemClick triggered for position: " + position);

            currentStudent = Student.students.get(position);
            Log.v("MainActivity", "Current student: " + currentStudent.name + " " + currentStudent.surname);

            imageView.setImageResource(currentStudent.image);
            Log.v("MainActivity", "Image resource set for student: " + currentStudent.name);

            String personalData = "Student data:\n" +
                    currentStudent.name + " " + currentStudent.surname + ", "
                    + (int)currentStudent.getAge() + " years old,\n" +
                    "Department: " + currentStudent.department + "\n"
                    + "Average: " + currentStudent.average;
            studentData.setText(personalData);
            Log.v("MainActivity", "Personal data set for student: " + currentStudent.name + " " + currentStudent.surname);
        }
    };
    */



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        database = db.getWritableDatabase();

        this.imageView = findViewById(R.id.imageView);
        this.adapter = new StudentView(this, Student.students, new StudentView.OnItemClickListener() {
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

        this.listView = findViewById(R.id.listView);
        this.listView.setAdapter(adapter);
        this.listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        //this.listView.setOnItemClickListener(listListener);

        this.studentData = findViewById(R.id.studentDescription);

        this.radioGroup = findViewById(R.id.radioGroup);
        this.radioGroup.setOnCheckedChangeListener(changeOrder);


        // from GEEKS for GEEKS
        // drawer layout instance to toggle the menu icon to open
        // drawer and back button to close drawer
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        loadFromDatabase();
    }

    public void loadFromDatabase() {
        Cursor cursor = selectStudents();

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

    public void clearDatabase(View view) {
        Cursor cursor = selectStudents();

        Student.students.clear();

        if (cursor.getCount() == 0) {
            Toast.makeText(MainActivity.this, "Database is already empty", Toast.LENGTH_SHORT).show();

            return;
        }

        if (cursor != null) {
            cursor.moveToFirst();
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
                db.removeRecord(database, id);
            } while (cursor.moveToNext());
            cursor.close();
            Toast.makeText(MainActivity.this, "Cleared the table students", Toast.LENGTH_SHORT).show();
        }

        loadFromDatabase();
    }

    public void addStudent(View view) {

    }

    public void seedDatabase(View view) {
        if (isDatabaseEmpty()) {
            db.addRecord(database, R.drawable.facet1, "Antczak", "Stanisław", "1999-09-14", "Mechaniczny", 4.13);
            db.addRecord(database, R.drawable.facet2, "Antkiewicz", "Janusz", "2000-09-14", "Mechaniczny", 4.19);
            db.addRecord(database, R.drawable.facet3, "Bartnik", "Paweł", "2000-07-14", "Nawigacyjny", 4.13);
            db.addRecord(database, R.drawable.facet4, "Bartkowiak", "Adam", "2001-09-14","Elektryczny", 3.13);
            db.addRecord(database, R.drawable.facet5, "Zagórski", "Paweł", "2000-03-11","Elektryczny", 3.99);
            db.addRecord(database, R.drawable.facet6, "Zawadzki", "Piotr", "2000-12-17","PiT", 4.01);
            db.addRecord(database, R.drawable.facet7, "Kowalski", "Bartosz", "2000-06-25","Nawigacyjny", 3.99);
            db.addRecord(database, R.drawable.facet10, "Janowski", "Bartosz", "2000-01-12","Elektryczny", 3.29);
            db.addRecord(database, R.drawable.facet8, "Żurawski", "Mikołaj", "2001-04-14","PiT", 4.89);
            db.addRecord(database, R.drawable.facet9, "Filipiak", "Paweł", "2000-09-24","PiT", 3.99);
            db.addRecord(database, R.drawable.facet11, "Gutkowski", "Zdzisław", "2000-07-29","Nawigacyjny", 4.05);
            Toast.makeText(MainActivity.this, "Database seeded", Toast.LENGTH_SHORT).show();
            loadFromDatabase();
        } else {
            Toast.makeText(MainActivity.this, "Database is not empty - values don't get seeded", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isDatabaseEmpty() {
        Cursor cursor = database.rawQuery("SELECT COUNT(*) FROM " + db.TABLE_NAME, null);
        if (cursor != null) {
            cursor.moveToFirst();
            int count = cursor.getInt(0);
            cursor.close();
            return count == 0;
        }
        return true;
    }

    public Cursor selectStudents() {
        return database.rawQuery("Select * FROM "+ db.TABLE_NAME, null);
    }

    RadioGroup.OnCheckedChangeListener changeOrder =  new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {

            RadioButton checkedRadioButton = group.findViewById(checkedId);
            boolean isChecked = checkedRadioButton.isChecked();

            if (isChecked) {

                int id = group.getCheckedRadioButtonId();

                if(id == R.id.sortByName) {
                    Student.students.sort(Student.compareByName);
                } else if (id == R.id.sortByAverage) {
                    Student.students.sort(Student.compareByAverage);
                } else {
                    Log.v("in on checked listener",
                            "following radio button doesn't exist");
                }

                adapter.notifyDataSetChanged();
            }

        }
    };

    // from GEEKS for GEEKS
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
