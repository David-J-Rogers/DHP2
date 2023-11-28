package com.example.dhp2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.github.jinatonic.confetti.CommonConfetti;

public class MilestoneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milestone);

        Button exercise1Button = findViewById(R.id.exercise1Button);
        Button exercise2Button = findViewById(R.id.exercise2Button);
        Button exercise3Button = findViewById(R.id.exercise3Button);
        Button assessButton = findViewById(R.id.assessButton);
        Button doneButton = findViewById(R.id.doneButton);

        final ExerciseManager exerciseManager = ExerciseManager.getInstance(this);
        int milestoneNumber = getIntent().getIntExtra("milestoneNumber", 1);

        exercise1Button.setOnClickListener(createExerciseClickListener(milestoneNumber, 1, exerciseManager));
        exercise2Button.setOnClickListener(createExerciseClickListener(milestoneNumber, 2, exerciseManager));
        exercise3Button.setOnClickListener(createExerciseClickListener(milestoneNumber, 3, exerciseManager));

        boolean isAssessmentCompleted = getPreferences(MODE_PRIVATE).getBoolean("assessmentCompleted", false);

        if (isAssessmentCompleted) {
            doneButton.setVisibility(View.VISIBLE);
        } else {
            doneButton.setVisibility(View.GONE);
        }

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                triggerConfetti();
                SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
                editor.putBoolean("assessmentCompleted", false);
                editor.apply();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MilestoneActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }, 750);
            }
        });

        assessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (exerciseManager.isExerciseUnlocked(4)) {
                    SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
                    editor.putBoolean("assessmentCompleted", true);
                    editor.apply();

                    Intent intent = new Intent(MilestoneActivity.this, ExerciseActivity.class);
                    int randomExerciseNumber = exerciseManager.generateRandomExerciseForMilestone(milestoneNumber);
                    intent.putExtra("exerciseNumber", 4);
                    intent.putExtra("randomExerciseNumber", randomExerciseNumber);
                    startActivity(intent);
                } else {
                    Toast.makeText(MilestoneActivity.this, "Exercise 4 is locked.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void triggerConfetti() {
        ConstraintLayout container = findViewById(R.id.milestoneLayout);
        Button doneButton = findViewById(R.id.doneButton);

        int[] location = new int[2];
        doneButton.getLocationOnScreen(location);
        int x = location[0] + doneButton.getWidth() / 2;
        int y = location[1] + doneButton.getHeight() / 2 - 250;
        CommonConfetti.explosion(container, x, y, new int[]{Color.GREEN, Color.BLUE})
                .oneShot();
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
                    finish();
                } else {
                    Toast.makeText(MilestoneActivity.this, "Exercise " + exerciseNumber + " is locked.", Toast.LENGTH_SHORT).show();
                }
            }
        };
    }
}
