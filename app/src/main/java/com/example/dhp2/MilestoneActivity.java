package com.example.dhp2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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

        final ExerciseManager exerciseManager = ExerciseManager.getInstance(this);
        int milestoneNumber = getIntent().getIntExtra("milestoneNumber", 1);

        exercise1Button.setOnClickListener(createExerciseClickListener(milestoneNumber, 1, exerciseManager));
        exercise2Button.setOnClickListener(createExerciseClickListener(milestoneNumber, 2, exerciseManager));
        exercise3Button.setOnClickListener(createExerciseClickListener(milestoneNumber, 3, exerciseManager));

        assessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (exerciseManager.isExerciseUnlocked(4)) {
                    Intent intent = new Intent(MilestoneActivity.this, AssessmentActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MilestoneActivity.this, "Assessment is locked.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private View.OnClickListener createExerciseClickListener(final int milestoneNumber, final int exerciseNumber, final ExerciseManager exerciseManager) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (exerciseManager.isExerciseUnlocked(exerciseNumber)) {
                    int randomExerciseNumber = exerciseManager.generateRandomExerciseForMilestone(milestoneNumber);

                    Intent intent = new Intent(MilestoneActivity.this, ExerciseActivity.class);
                    intent.putExtra("randomExerciseNumber", randomExerciseNumber);
                    intent.putExtra("exerciseNumber", exerciseNumber);
                    startActivity(intent);
                } else {
                    Toast.makeText(MilestoneActivity.this, "Exercise " + exerciseNumber + " is locked.", Toast.LENGTH_SHORT).show();
                }
            }
        };
    }
}
