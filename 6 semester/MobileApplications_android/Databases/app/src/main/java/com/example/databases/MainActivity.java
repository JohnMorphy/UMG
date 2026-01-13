package com.example.databases;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

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

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.nav_list_students) {
                    loadFragment(new StudentListFragment());
                } else if(id == R.id.nav_add_student) {
                    loadFragment(new StudentCreateFragment());
                }
                drawerLayout.closeDrawers();
                return true;
            }
        });

        // Load the default fragment
        if (savedInstanceState == null) {
            loadFragment(new StudentListFragment());
        }
    }

    private void loadFragment(Fragment fragment) {
        // Create a FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();
        // Create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // Replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit(); // save the changes
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
