package com.example.adapters_24;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    public MainActivity getMainActivity() {
        return this;
    }

    String[] voivodeship;
    ListView listView;
    Toast toast;
    Button showButton;

    Set<String> toggledVoivodeship;

    protected void onCreate(Bundle savedInstanceState) {

        toggledVoivodeship = new HashSet<>();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        voivodeship = getResources().getStringArray(R.array.voivodeship);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_checked, voivodeship);

        listView = findViewById(R.id.voivodeshipList);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        toast = Toast.makeText(this, "",Toast.LENGTH_LONG);
        listView.setOnItemClickListener(listListener);

        showButton = findViewById(R.id.button);
        showButton.setOnClickListener(showListener);

    }

    AdapterView.OnItemClickListener listListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            if (listView.isItemChecked(position)) {
                toggledVoivodeship.add(voivodeship[position]);
            } else {
                toggledVoivodeship.remove(voivodeship[position]);
            }

        }
    };

    View.OnClickListener showListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            StringBuilder text = new StringBuilder();
            if(toggledVoivodeship.isEmpty()) {
                text.append("No voivodeship chosen");
            } else {
                text.append("Voivodeships chosen:\n");
                for (String voivodeship:toggledVoivodeship) {
                    text.append(voivodeship+ " ");
                }
            }

            Toast.makeText(getMainActivity(), text.toString(),
                    Toast.LENGTH_LONG).show();

        }
    };


}