package com.example.madproject;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class ForgotPasswordActivity extends AppCompatActivity{
    private EditText emailEditText;
    private EditText newPasswordEditText;
    private EditText confirmPasswordEditText;
    private Button resetPasswordButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        emailEditText = findViewById(R.id.emailEditText);
        newPasswordEditText = findViewById(R.id.newPassword);
        confirmPasswordEditText = findViewById(R.id.confirmPassword);
        resetPasswordButton = findViewById(R.id.resetPasswordButton);

        resetPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get email, new password, and confirm password from EditText fields
                String email = emailEditText.getText().toString().trim();
                String newPassword = newPasswordEditText.getText().toString().trim();
                String confirmPassword = confirmPasswordEditText.getText().toString().trim();

                // Check if email field is empty
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(ForgotPasswordActivity.this, "Please enter your email", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Check if new password and confirm password fields are empty
                if (TextUtils.isEmpty(newPassword) || TextUtils.isEmpty(confirmPassword)) {
                    Toast.makeText(ForgotPasswordActivity.this, "Please enter your new password and confirm it", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Check if new password matches confirm password
                if (!newPassword.equals(confirmPassword)) {
                    Toast.makeText(ForgotPasswordActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }

                // If all validations pass, navigate back to LoginActivity
                Intent intent = new Intent(ForgotPasswordActivity.this, SignIn.class);
                startActivity(intent);
            }
        });
    }
}

