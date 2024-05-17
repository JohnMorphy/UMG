package com.example.studentlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    ImageView imageView;
    Student currentStudent;
    ListView listView;
    TextView textView;
    RadioGroup radioGroup;
    BaseAdapter adapter;

    AdapterView.OnItemClickListener listListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            currentStudent = Student.students.get(position);

            imageView.setImageResource(currentStudent.image);
            String personalData =
                    currentStudent.surname + " " + currentStudent.average + ", "
                            + (int)currentStudent.getAge() + " years old";
            textView.setText(personalData);

        }
    };

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Student.students.isEmpty()) {
            new Student("Stanisław", "Antczak", "Mechaniczny", "1998-01-11", 4.13,R.drawable.facet1);
            new Student("Janusz", "Antkiewicz", "Mechaniczny", "1998-08-11", 4.19,R.drawable.facet2);
            new Student("Paweł", "Bartnik", "Nawigacyjny", "1998-01-11", 4.13,R.drawable.facet3);
            new Student("Adam", "Bartkowiak", "Elektryczny", "1996-07-11", 3.13,R.drawable.facet4);
            new Student("Paweł", "Zagórski", "Elektryczny", "1995-01-11", 3.99,R.drawable.facet5);
            new Student("Piotr", "Zawadzki", "PiT", "1997-03-21", 4.01,R.drawable.facet6);
            new Student("Bartosz", "Kowalski", "Nawigacyjny", "1995-11-11", 3.99,R.drawable.facet7);
            new Student("Bartosz", "Janowski", "Elektryczny", "1995-07-11", 3.29,R.drawable.facet7a);
            new Student("Mikołaj", "Żurawski", "PiT", "1997-12-21", 4.89,R.drawable.facet8);
            new Student("Paweł", "Filipiak", "PiT", "2001-04-29", 3.99,R.drawable.facet9);
            new Student("Zdzisław", "Gutkowski", "Nawigacyjny", "2001-05-29", 4.05,R.drawable.stud);
        }

        this.imageView = findViewById(R.id.imageView);
        this.adapter = new MyListAdapter(this, Student.students);

        this.listView = findViewById(R.id.listView);
        this.listView.setAdapter(adapter);
        this.listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        this.listView.setOnItemClickListener(listListener);

        this.textView = findViewById(R.id.textView);

        this.radioGroup = findViewById(R.id.radioGroup);
        this.radioGroup.setOnCheckedChangeListener(changeOrder);
    }

}