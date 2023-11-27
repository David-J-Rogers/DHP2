package com.example.dhp2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class AssessmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment);

        Button backButton = findViewById(R.id.backButtonA);
        Button completeButton = findViewById(R.id.completeButtonA);
        RadioGroup radioGroup = findViewById(R.id.assessmentRadioGroup);
        EditText commentsEditText = findViewById(R.id.commentsEditText);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        completeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                String selectedRating = selectedRadioButton.getText().toString();

                String comments = commentsEditText.getText().toString();

                int currentMilestoneNumber = 1;
                int nextMilestoneNumber = currentMilestoneNumber + 1;

                MilestoneManager milestoneManager = MilestoneManager.getInstance(AssessmentActivity.this);

                milestoneManager.unlockMilestone(nextMilestoneNumber);

                Intent intent = new Intent(AssessmentActivity.this, MilestoneActivity.class);
                startActivity(intent);

                finish();
            }
        });
    }
}
