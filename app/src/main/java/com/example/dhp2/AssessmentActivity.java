package com.example.dhp2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.github.jinatonic.confetti.CommonConfetti;

public class AssessmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment);

        Button completeButton = findViewById(R.id.completeButtonA);
        RadioGroup radioGroup = findViewById(R.id.assessmentRadioGroup);
        EditText commentsEditText = findViewById(R.id.commentsEditText);


        completeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);

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
