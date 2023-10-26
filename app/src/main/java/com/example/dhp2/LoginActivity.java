package com.example.dhp2;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.dhp2.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);  // Set the layout XML for the login page

        // Find the UI components by their IDs
        EditText usernameEditText = findViewById(R.id.usernameEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);
        Button loginButton = findViewById(R.id.loginButton);

        // Set a click listener for the login button
        loginButton.setOnClickListener(view -> {
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            // Validate the username and password (e.g., check against a database or API).
            if (isValidCredentials(username, password)) {
                // Successful login, navigate to the next screen or perform required actions.
            } else {
                // Display an error message to the user.
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean isValidCredentials(String username, String password) {

        if (username.equals("example") && password.equals("password")) {
            // Successful login
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);

            // Finish the LoginActivity so that the user can't navigate back to it after login
            finish();

            return true;
        } else {
            // Display an error message to the user.
            Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

}
