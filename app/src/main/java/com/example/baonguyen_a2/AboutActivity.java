package com.example.baonguyen_a2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {
    Button btnRestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        btnRestart = findViewById(R.id.btnRestart);


        btnRestart.setOnClickListener(v -> {
            Intent in2 = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(in2);
        });
    }
}
