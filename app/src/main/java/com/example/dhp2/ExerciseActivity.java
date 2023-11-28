package com.example.dhp2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dhp2.R;

public class ExerciseActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    private SensorEventListener sensorEventListener;
    private boolean isDeviceMoved = false;

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

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorEventListener = new SensorEventListener() {
            private static final float MOVEMENT_THRESHOLD = 10.0f;
            private float lastX, lastY, lastZ;

            @Override
            public void onSensorChanged(SensorEvent event) {
                float x = event.values[0];
                float y = event.values[1];
                float z = event.values[2];

                float deltaX = Math.abs(lastX - x);
                float deltaY = Math.abs(lastY - y);
                float deltaZ = Math.abs(lastZ - z);
                if (deltaX > MOVEMENT_THRESHOLD || deltaY > MOVEMENT_THRESHOLD || deltaZ > MOVEMENT_THRESHOLD) {
                    isDeviceMoved = true;
                }
                lastX = x;
                lastY = y;
                lastZ = z;
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {}
        };
        sensorManager.registerListener(sensorEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        completeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isDeviceMoved) {
                    int nextExerciseNumber = exerciseNumber + 1;
                    ExerciseManager.unlockExercise(nextExerciseNumber);

                    Intent intent = new Intent(ExerciseActivity.this, AssessmentActivity.class);
                    startActivity(intent);

                    finish();
                } else {
                    Toast.makeText(ExerciseActivity.this, "Please move your device to complete the exercise.", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        sensorManager.unregisterListener(sensorEventListener);
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
