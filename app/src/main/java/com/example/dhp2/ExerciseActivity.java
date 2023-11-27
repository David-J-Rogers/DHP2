package com.example.dhp2;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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
        int randomExerciseNumber = getIntent().getIntExtra("randomExerciseNumber", 1);

        TextView exerciseDescriptionTextView = findViewById(R.id.exerciseDescriptionTextView);
        ImageView exerciseImageView = findViewById(R.id.exerciseImageView);

        String exerciseDescription = getExerciseDescription(randomExerciseNumber, getResources());
        int exerciseImageResId = getExerciseImageResource(randomExerciseNumber);

        exerciseDescriptionTextView.setText(exerciseDescription);
        exerciseImageView.setImageResource(exerciseImageResId);

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

    private String getExerciseDescription(int randomExerciseNumber, Resources resources) {
        String resourceName = "exercise" + randomExerciseNumber + "_description";
        int resourceId = resources.getIdentifier(resourceName, "string", getPackageName());
        return resources.getString(resourceId);
    }

    private int getExerciseImageResource(int randomExerciseNumber) {
        String resourceName = "exercise" + randomExerciseNumber;
        int resourceId = getResources().getIdentifier(resourceName, "drawable", getPackageName());

        if (resourceId == 0) {
            return R.drawable.default_image;
        }

        return resourceId;
    }

}
