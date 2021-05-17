package com.example.loginsignupactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
     Button signup;
    EditText username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signup = findViewById(R.id.signup);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = username.getText().toString();
                String pass = password.getText().toString();
                if(!isValidPassword(pass))
                {
                    Toast.makeText(MainActivity.this, "Invalid Password!", Toast.LENGTH_SHORT).show();
                    Log.d("MyActivity", "Error");
                    return;
                }
                Intent i = new Intent(MainActivity.this,MainActivity2.class);
                i.putExtra("username",email);
                i.putExtra("passer",pass);
                startActivity(i);
                Toast.makeText(MainActivity.this, "You've Successfully Signed Up!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    Pattern lowercase = Pattern.compile("^.*[a-z].*$");
    Pattern uppercase = Pattern.compile("^.*[A-Z].*$");
    Pattern number = Pattern.compile("^.*[0-9].*$");
    Pattern specialChar = Pattern.compile("^.*[^a-zA-Z0-9].*$");
    private Boolean isValidPassword(String passw)
    {
        if(passw.length()<8)
        {
            return false;
        }
        if(!lowercase.matcher(passw).matches())
        {
            return false;
        }
        if(!uppercase.matcher(passw).matches())
        {
            return false;
        }
        if(!number.matcher(passw).matches())
        {
            return false;
        }
        if(!specialChar.matcher(passw).matches())
        {
            return false;
        }
        return true;
    }
}