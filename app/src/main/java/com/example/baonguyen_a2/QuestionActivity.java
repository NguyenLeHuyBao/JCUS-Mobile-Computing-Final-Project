package com.example.baonguyen_a2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuestionActivity extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1, rb2, rb3, rb4;

    String[] questions = {
            "1. Android Is Developed By?",
            "2. Android Web Browser Is Based On?",
            "3. Which Media Format Is Not Supported By Android?",
            "4. In Which Directory  XML Layout Files Are Stored?",
            "5. Which Code Used By Android Is Not A Open Source.?",
            "6. How Many Levels Of Securities Are In Android?",
            "7. Which Of The Following Does Not Belong To Transitions?",
            "8. What Are The Functionalities In AsyncTask In Android?",
            "9. View Pager Is Used For",
            "10. Which Programming Language  Is Used For Android Application Development?"
    };

    String[] answers = {"Android Inc", "Open-source Webkit", "AVI", "/res/layout", "WiFi Driver", "App And Kernel Level Security",
            "ViewSlider", "OnPostExecution()", "Swiping Fragments", "Java"};
    String[] opt = {
            "Apple", "Microsoft", "Google", "Android Inc",
            "Chrome", "Open-source Webkit", "Safari", "Firefox",
            "MP4", "AVI", "MIDI", "MPEG",
            "/assets", "/src", "/res/values", "/res/layout",
            "Video Driver", "WiFi Driver", "Device Driver", "Bluetooth Driver",
            "Android Level Security", "App And Kernel Level Security", "Java Level Security", "None Of The Above",
            "ViewFlipper", "ViewAnimator", "ViewSwitcher", "ViewSlider",
            "OnPreExecution()", "OnPostExecution()", "DoInBackground()", "OnProgressUpdate()",
            "Swiping Activities", "Swiping Fragments", "Paging Down List Items", "View Pager Is Not Supported By Android SDK",
            "NodeJs", "PHP", "JSX", "Java"
    };
    int flag = 0;
    public static int marks = 0, correct = 0, wrong = 0;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        final TextView score = findViewById(R.id.textView4);
        TextView textView = findViewById(R.id.DispName);
        Intent intent = getIntent();
        String name = intent.getStringExtra("myname");

        if (name.trim().equals(""))
            textView.setText("Hello User");
        else
            textView.setText("Hello " + name);

        submitbutton = findViewById(R.id.button3);
        quitbutton = findViewById(R.id.buttonquit);
        tv = findViewById(R.id.tvque);

        radio_g = findViewById(R.id.answersgrp);
        rb1 = findViewById(R.id.radioButton);
        rb2 = findViewById(R.id.radioButton2);
        rb3 = findViewById(R.id.radioButton3);
        rb4 = findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(v -> {
            if (radio_g.getCheckedRadioButtonId() == -1) {
                Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                return;
            }
            RadioButton uans = findViewById(radio_g.getCheckedRadioButtonId());
            String ansText = uans.getText().toString();
            if (ansText.equals(answers[flag])) {
                correct++;
                Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
            } else {
                wrong++;
                Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
            }

            flag++;

            if (score != null)
                score.setText("" + correct);

            if (flag < questions.length) {
                tv.setText(questions[flag]);
                rb1.setText(opt[flag * 4]);
                rb2.setText(opt[flag * 4 + 1]);
                rb3.setText(opt[flag * 4 + 2]);
                rb4.setText(opt[flag * 4 + 3]);
            } else {
                marks = correct;
                Intent in = new Intent(getApplicationContext(), ResultActivity.class);
                startActivity(in);
            }
            radio_g.clearCheck();
        });

        quitbutton.setOnClickListener(v -> {
            Intent intent1 = new Intent(getApplicationContext(), ResultActivity.class);
            startActivity(intent1);
        });
    }
}

