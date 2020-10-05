package com.example.firebaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class MainScreen extends AppCompatActivity {

    private Button menuButton;
    private TextView menuText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        menuButton = (Button) findViewById(R.id.menuButton);
        menuText = (TextView) findViewById(R.id.menuText);

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();
            }
        });
    }
        public void openMainActivity(){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

    }
