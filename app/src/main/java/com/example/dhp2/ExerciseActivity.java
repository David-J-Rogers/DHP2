package com.example.dhp2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dhp2.R;

public class ExerciseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        Button backButton = findViewById(R.id.backButton);
        Button completeButton = findViewById(R.id.completeButton);
        int exerciseNumber = getIntent().getIntExtra("exerciseNumber", 1);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        completeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nextExerciseNumber = exerciseNumber + 1;
                ExerciseManager.unlockExercise(nextExerciseNumber);

                Intent intent = new Intent(ExerciseActivity.this, MilestoneActivity.class);
                startActivity(intent);

                finish();
            }
        });
    }
}
