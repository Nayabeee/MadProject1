package com.example.madproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {
    private EditText fullNameEditText, usernameEditText, emailEditText, passwordEditText, confirmPasswordEditText;
    private CheckBox termsCheckbox;
    private TextView member;
    private Button signupButton;
    private RadioButton student,teacher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        fullNameEditText = findViewById(R.id.firstName);
        usernameEditText = findViewById(R.id.username);
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        confirmPasswordEditText = findViewById(R.id.confirmPassword);
        termsCheckbox = findViewById(R.id.termsCheckbox);
        signupButton = findViewById(R.id.signupButton);

        member = findViewById(R.id.alreadyMemberText);

        student=findViewById(R.id.studentRadioButton);
        teacher=findViewById(R.id.teacherRadioButton);


        member.setOnClickListener(v ->{
            Intent intent = new Intent(SignUp.this, SignIn.class);
            startActivity(intent);
        });
        signupButton.setOnClickListener(v -> {
            String fullname = fullNameEditText.getText().toString().trim();
            String username = usernameEditText.getText().toString().trim();
            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();
            String confirmPassword = confirmPasswordEditText.getText().toString().trim();

            if (TextUtils.isEmpty(fullname)|| TextUtils.isEmpty(username) ||
                    TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(confirmPassword)) {
                Toast.makeText(SignUp.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            if(isValidPassword(password)){
                Toast.makeText(SignUp.this, "Password is too weak", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!password.equals(confirmPassword)) {
                Toast.makeText(SignUp.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!termsCheckbox.isChecked()) {
                Toast.makeText(SignUp.this, "You must accept the terms of use and privacy policy", Toast.LENGTH_SHORT).show();
                return;
            }
            // Add your signup logic here (e.g., save data, navigate to another activity)
            Toast.makeText(SignUp.this, "Sign Up Successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(SignUp.this, HomeActivityTwo.class);
            startActivity(intent);
        });

    }
    private boolean isValidPassword(String password) {
        // Password must contain at least one capital letter, one number, and one symbol
        return password.matches("^(?=.[A-Z])(?=.\\d)(?=.[@$!%?&])[A-Za-z\\d@$!%*?&]+$");
    }

}
