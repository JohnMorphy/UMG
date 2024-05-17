package com.example.intentions_basics;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    Button button_changeName;
    Button button_onActivityImage;
    ImageView profileImage;

    final static int CHANGE_NAME = 1;
    final static int CHANGE_IMAGE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.textView = findViewById(R.id.MainText);
        this.profileImage = findViewById(R.id.profilePicture);


        this.button_changeName = findViewById(R.id.button);
        this.button_onActivityImage = findViewById(R.id.button_onActivityImage);

        this.button_onActivityImage.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view) {
                        // choosing images from existing ones
                        //getImageFromFolder.launch("image/*");
                        takePicture.launch("image/*");
                    }
                });

        this.button_changeName.setOnClickListener(this::changeActivity);
    }

    @Override
    public void onActivityResult(int request_code, int resultCode, Intent message) {

        super.onActivityResult(request_code, resultCode, message);

        if(resultCode == RESULT_OK) {
            if (request_code == CHANGE_NAME) {
                String result = " Name:\n" + message.getStringExtra("textValue");

                this.textView.setText(result);
            }

            if (request_code == CHANGE_IMAGE) {
                Bundle extras = message.getExtras();
                if (extras.get("image") != null) {
                    Bitmap image = (Bitmap) extras.get("image");
                    profileImage.setImageBitmap(image);
                }
            }
        } else {
            Log.v("ERROR", "on activity result error");
        }
    }

    public void changeActivity (View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("textValue", textView.getText().toString());
        changeText.launch(intent);

        // using regular startOnActivityResult (deprecated)
        // startActivityForResult(intent, CHANGE_NAME);

    }

    public void changeProfilePicture (View view){
        Intent intent = new Intent();
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, CHANGE_IMAGE);
        }
    }


    ActivityResultLauncher<Intent> changeText = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Intent data;
                    data = result.getData();
                    if (result.getResultCode() == CHANGE_NAME) {
                        String text = data.getStringExtra("textValue");
                        textView.setText(text);
                    }
                }
            });


    ActivityResultLauncher<String> getImageFromFolder = registerForActivityResult(
            new ActivityResultContracts.GetContent(),
                    new ActivityResultCallback<Uri>() {
        @Override
        public void onActivityResult(Uri result) {
            if(result!=null ){
                Log.v("RETURNING", result.toString());
                profileImage.setImageURI(result);}
        }
    });



    ActivityResultLauncher<Uri> takePicture = registerForActivityResult(
        new ActivityResultContracts.TakePicture(),
                new ActivityResultCallback<Boolean>() {
        @Override
        public void onActivityResult(Boolean result) {
            if(result){
                U
                Log.v("RETURNING_IMAGE", result.toString());
                profileImage.setImageURI();
            }
        }});
    

}