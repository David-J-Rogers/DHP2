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
                // Add your custom logic here.

                // Create an intent to navigate back to the MainActivity
                Intent intent = new Intent(ExerciseActivity.this, MainActivity.class);
                startActivity(intent);

                // Finish the ExerciseActivity to remove it from the back stack
                finish();
            }
        });
    }
}
