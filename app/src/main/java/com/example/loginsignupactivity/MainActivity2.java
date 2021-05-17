package com.example.loginsignupactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    public Button login;
    public EditText username, password;
    public int counter = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        login = findViewById(R.id.signup);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        String regmail = getIntent().getStringExtra("username");
        String regpass = getIntent().getStringExtra("passer");
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if(regmail.equals(user) && regpass.equals(pass))
                {
                    Intent i = new Intent(MainActivity2.this ,MainActivity3.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(MainActivity2.this, "Invalid Credentials!", Toast.LENGTH_SHORT).show();
                }
                counter--;
                if(counter==0)
                {
                    Toast.makeText(MainActivity2.this, "Failed Login Attempts!", Toast.LENGTH_SHORT).show();
                    login.setEnabled(false);
                }
            }
        });
    }
}