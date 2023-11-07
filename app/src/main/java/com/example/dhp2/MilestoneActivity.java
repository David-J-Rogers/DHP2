package com.example.dhp2;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.dhp2.ExerciseManager;
import androidx.appcompat.app.AppCompatActivity;

public class MilestoneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milestone);

        Button exercise1Button = findViewById(R.id.exercise1Button);
        Button exercise2Button = findViewById(R.id.exercise2Button);
        Button exercise3Button = findViewById(R.id.exercise3Button);
        Button assessButton = findViewById(R.id.assessButton);
        ExerciseManager exerciseManager = ExerciseManager.getInstance(this);

        exercise1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MilestoneActivity.this, ExerciseActivity.class);
                startActivity(intent);
            }
        });

        exercise2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (exerciseManager.isExerciseUnlocked(2)) {
                    int exerciseNumber = 2;
                    Intent intent = new Intent(MilestoneActivity.this, ExerciseActivity.class);
                    intent.putExtra("exerciseNumber", exerciseNumber);
                    startActivity(intent);
                } else {
                    Toast.makeText(MilestoneActivity.this, "Exercise 2 is locked.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        exercise3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (exerciseManager.isExerciseUnlocked(3)) {
                    int exerciseNumber = 3;
                    Intent intent = new Intent(MilestoneActivity.this, ExerciseActivity.class);
                    intent.putExtra("exerciseNumber", exerciseNumber);
                    startActivity(intent);
                } else {
                    Toast.makeText(MilestoneActivity.this, "Exercise 3 is locked.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        assessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (exerciseManager.isExerciseUnlocked(4)) {
                    Intent intent = new Intent(MilestoneActivity.this, ExerciseActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MilestoneActivity.this, "Assessment is locked.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
