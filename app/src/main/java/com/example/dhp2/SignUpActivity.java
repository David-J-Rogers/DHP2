package com.example.dhp2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class SignUpActivity extends AppCompatActivity{
    private EditText usernameEditText;
    private EditText passwordEditText;
    private EditText ageEditText;
    private EditText timeOfSurgeryEditText;
    private Button signUpButton;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        ageEditText = findViewById(R.id.ageEditText);
        timeOfSurgeryEditText = findViewById(R.id.dateOfSurgeryEditText);
        signUpButton = findViewById(R.id.signUpButton);
        dbHelper = new DBHelper(this);

        signUpButton.setOnClickListener(view -> {
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            int age = Integer.parseInt(ageEditText.getText().toString());
            String timeOfSurgery = timeOfSurgeryEditText.getText().toString();
            dbHelper.addPatient(username, password, age, timeOfSurgery, 0, 0, 0, 0);
            Toast.makeText(getApplicationContext(), "Sign up successful!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        });
    }
}
