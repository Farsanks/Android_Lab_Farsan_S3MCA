package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText user,mob,pass1,pass2,email;
    Button submit;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user=findViewById(R.id.user);
        mob=findViewById(R.id.mob);
        email=findViewById(R.id.email);
        pass1=findViewById(R.id.pass1);
        pass2=findViewById(R.id.pass2);
        submit=findViewById(R.id.sub);
        sharedPreferences = getSharedPreferences("UserDetails", MODE_PRIVATE);
        editor =sharedPreferences.edit();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=user.getText().toString().trim();
                String mobno=mob.getText().toString().trim();
                String mail=email.getText().toString().trim();
                String passw1=pass1.getText().toString().trim();
                String passw2=pass2.getText().toString().trim();

                if(username.isEmpty())
                {
                    user.setError("username is empty");
                    user.requestFocus();
                    return;
                }

                if(mobno.isEmpty())
                {
                    mob.setError("Mobile Number is empty");
                    mob.requestFocus();
                    return;
                }

                if(mail.isEmpty())
                {
                    email.setError("Email is empty");
                    email.requestFocus();
                    return;
                }

                if(passw1.isEmpty())
                {
                    pass1.setError("Enter password");
                    pass1.requestFocus();
                    return;
                }

                if(passw2.isEmpty())
                {
                    pass2.setError("Confirm Password");
                    pass2.requestFocus();
                    return;
                }

                if(passw1.length()<6)
                {
                    pass1.setError("length must be minimum 6 characters");
                    pass1.requestFocus();
                    return;
                }

                if(!passw1.equals(passw2))
                {
                    pass2.setError("Password not match");
                    pass2.requestFocus();
                    return;
                }

                Toast.makeText(MainActivity.this,"Registration successful",Toast.LENGTH_SHORT).show();
                editor.putString("keyusername",username);
                editor.putString("keymobile",mobno);
                editor.putString("keyemail",mail);
                editor.putString("keypassword",passw2);
                editor.apply();
            }
        });
    }
}
