package com.example.adapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] voivodeship = getResources().getStringArray(R.array.voivodeship);
    ListView listView;
    Toast toast;
    Button showButton;

    ArrayAdapter<String> adapter = new ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_checked, voivodeship);

    AdapterView.OnItemClickListener listListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        }
    };

    View.OnClickListener showListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            StringBuilder text = new StringBuilder();
            for(int i=0; i<adapter.getCount(); i++) {
                text.append(adapter.getItem(i));
            }

        }
    };


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        voivodeship = getResources().getStringArray(R.array.voivodeship);

        listView = findViewById(R.id.voivodeshipList);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        toast = Toast.makeText(this, "",Toast.LENGTH_LONG);

        showButton.findViewById(R.id.button);
        showButton.setOnClickListener(showListener);

    }

}