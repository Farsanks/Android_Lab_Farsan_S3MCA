package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageView;
import android.content.Intent;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    private TextView tvName, tvTotal, tvPercentage;
    private ImageView ivMood;
    private String name;
    private int total;
    private double percentage;
    private boolean passed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvName = findViewById(R.id.tvName);
        tvTotal = findViewById(R.id.tvTotal);
        tvPercentage = findViewById(R.id.tvPercentage);
        ivMood = findViewById(R.id.ivMood);

        Intent intent = getIntent();
        if (intent != null) {
            name = intent.getStringExtra("name");
            int m1 = intent.getIntExtra("m1", 0);
            int m2 = intent.getIntExtra("m2", 0);
            int m3 = intent.getIntExtra("m3", 0);
            int m4 = intent.getIntExtra("m4", 0);

            total = m1 + m2 + m3 + m4;
            // each mark is out of 100, so percent = total / 400 * 100 = total / 4
            percentage = total / 4.0;

            passed = percentage >= 50.0;

            tvName.setText("Name: " + name);
            tvTotal.setText("Total: " + total + " / 400");
            // format percentage to 2 decimals
            tvPercentage.setText(String.format("Percentage: %.2f%%", percentage));

            if (passed) {
                ivMood.setImageResource(R.drawable.smile);
            } else {
                ivMood.setImageResource(R.drawable.sad);
            }
        }
    }

    // Called when user clicks "Show Result" button to go to ThirdActivity
    public void onShowResultClicked(View view) {
        Intent intent = new Intent(this, MainActivity3.class);
        intent.putExtra("name", name);
        intent.putExtra("percentage", percentage);
        intent.putExtra("passed", passed);
        startActivity(intent);
    }
}
