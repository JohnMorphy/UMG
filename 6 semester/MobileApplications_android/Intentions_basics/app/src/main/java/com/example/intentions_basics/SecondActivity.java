package com.example.intentions_basics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        this.text = findViewById(R.id.editTextText);

        Intent intent = getIntent();
        if(intent != null) {
            this.text.setText(intent.getStringExtra("textValue"));
        }

    }

    public void sendMessage(View view) {
        Intent message = new Intent();
        message.putExtra("textValue", text.getText().toString());
        setResult(MainActivity.CHANGE_NAME, message);
        finish();
    }

}
