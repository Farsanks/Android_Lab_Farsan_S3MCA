package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etMark1, etMark2, etMark3, etMark4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.etName);
        etMark1 = findViewById(R.id.etMark1);
        etMark2 = findViewById(R.id.etMark2);
        etMark3 = findViewById(R.id.etMark3);
        etMark4 = findViewById(R.id.etMark4);
    }

    public void onCalculateClicked(View view) {
        String name = etName.getText().toString().trim();
        String s1 = etMark1.getText().toString().trim();
        String s2 = etMark2.getText().toString().trim();
        String s3 = etMark3.getText().toString().trim();
        String s4 = etMark4.getText().toString().trim();

        if (name.isEmpty() || s1.isEmpty() || s2.isEmpty() || s3.isEmpty() || s4.isEmpty()) {
            Toast.makeText(this, "Please enter name and all four marks", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            int m1 = Integer.parseInt(s1);
            int m2 = Integer.parseInt(s2);
            int m3 = Integer.parseInt(s3);
            int m4 = Integer.parseInt(s4);

            // validate range 0-100 optionally
            if (!validMark(m1) || !validMark(m2) || !validMark(m3) || !validMark(m4)) {
                Toast.makeText(this, "Marks should be between 0 and 100", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("name", name);
            intent.putExtra("m1", m1);
            intent.putExtra("m2", m2);
            intent.putExtra("m3", m3);
            intent.putExtra("m4", m4);
            startActivity(intent);

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter valid integer marks", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validMark(int m) {
        return m >= 0 && m <= 100;
    }
}
