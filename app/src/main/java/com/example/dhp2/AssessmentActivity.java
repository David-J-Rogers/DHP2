package com.example.dhp2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dhp2.R;

public class AssessmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment);

        Button backButton = findViewById(R.id.backButtonA);
        Button completeButton = findViewById(R.id.completeButtonA);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the back button click event, e.g., go back to the previous activity or fragment.
                finish();
            }
        });

        completeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the "Complete" button click event.

                // Create an intent to navigate back to the MainActivity
                Intent intent = new Intent(AssessmentActivity.this, MainActivity.class);
                startActivity(intent);

                // Finish the ExerciseActivity to remove it from the back stack
                finish();
            }
        });

    }
}
