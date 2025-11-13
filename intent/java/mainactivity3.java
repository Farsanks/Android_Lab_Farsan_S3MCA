package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageView;
import android.content.Intent;

public class MainActivity3 extends AppCompatActivity {

    private TextView tvFinalMessage;
    private ImageView ivFinalMood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tvFinalMessage = findViewById(R.id.tvFinalMessage);
        ivFinalMood = findViewById(R.id.ivFinalMood);

        Intent intent = getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("name");
            double percentage = intent.getDoubleExtra("percentage", 0.0);
            boolean passed = intent.getBooleanExtra("passed", false);

            String resultText;
            if (passed) {
                resultText = String.format("%s has PASSED\nPercentage: %.2f%%", name, percentage);
                ivFinalMood.setImageResource(R.drawable.smile);
            } else {
                resultText = String.format("%s has FAILED\nPercentage: %.2f%%", name, percentage);
                ivFinalMood.setImageResource(R.drawable.sad);
            }

            tvFinalMessage.setText(resultText);
        }
    }
}
