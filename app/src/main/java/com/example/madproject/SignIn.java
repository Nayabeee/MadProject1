package com.example.madproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
//aiman
public class SignIn extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private CheckBox checkBoxRememberMe;
    private TextView textViewForgotPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        // Initializing UI components
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        checkBoxRememberMe = findViewById(R.id.checkBoxRememberMe);
        Button buttonLogin = findViewById(R.id.buttonLogin);
        textViewForgotPassword = findViewById(R.id.textViewForgotPassword);
        TextView SignUp=findViewById(R.id.SignUp);

        SignUp.setOnClickListener(v->{
            Intent intent=new Intent(SignIn.this, SignUp.class);
            startActivity(intent);
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve the entered username and password
                String username = editTextUsername.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                // Basic validation
                if (username.isEmpty() || password.isEmpty()) {
                    // Show toast if any of the fields are empty
                    Toast.makeText(SignIn.this, "Please enter both username and password", Toast.LENGTH_SHORT).show();
                }

                else {
                    // If both fields are filled and password meets requirements, simulate login
                    login(username, password);
                }
            }
        });
            // Adding onClickListener to the "Forgot Password?" TextView
            textViewForgotPassword.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(SignIn.this, "Forgot Password Clicked", Toast.LENGTH_SHORT).show();

                }
            });
        }

        // Simulating login functionality
        private void login(String username, String password) {
            if (username.equals("Rafia_sh004") && password.equals("rafia123")) {
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignIn.this, HomeActivityTwo.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show();
            }
        }

}

