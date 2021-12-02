package com.example.baonguyen_a2;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startbutton= findViewById(R.id.startBtn);
        Button aboutbutton= findViewById(R.id.aboutBtn);
        final EditText nametext= findViewById(R.id.editName);

        startbutton.setOnClickListener(v -> {
            if(nametext.length() == 0){
                Toast.makeText(getApplicationContext(), "Please enter your name", Toast.LENGTH_SHORT).show();
            }else{
                String name=nametext.getText().toString();
                Intent intent=new Intent(getApplicationContext(),QuestionActivity.class);
                intent.putExtra("myname",name);
                startActivity(intent);
            }

        });
        Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
        aboutbutton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
            startActivity(intent);

        });
    }


}