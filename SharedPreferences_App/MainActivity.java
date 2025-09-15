package com.example.sharedpreferences;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etPhone, etEmail, etPassword, etConfirmPassword;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);   // uses your provided XML

        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateAndRegister();
            }
        });
    }

    private void validateAndRegister() {
        String name = etName.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String confirm = etConfirmPassword.getText().toString().trim();

        if (TextUtils.isEmpty(name)) {
            etName.setError("Enter your name");
            return;
        }
        if (TextUtils.isEmpty(phone)) {
            etPhone.setError("Enter your phone number");
            return;
        }
        if (TextUtils.isEmpty(email)) {
            etEmail.setError("Enter your email");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            etPassword.setError("Enter a password");
            return;
        }
        if (password.length() < 6) {
            etPassword.setError("Password must be at least 6 characters");
            return;
        }
        if (!password.equals(confirm)) {
            etConfirmPassword.setError("Passwords do not match");
            return;
        }

        Toast.makeText(this,
                "Registration Successful\nName: " + name +
                        "\nPhone: " + phone +
                        "\nEmail: " + email,
                Toast.LENGTH_LONG).show();
    }
}
