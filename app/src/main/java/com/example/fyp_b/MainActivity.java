package com.example.fyp_b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView tv1,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.login_p_login_btn);
        tv1 = (TextView) findViewById(R.id.login_p_signup_panel);
        tv2 = (TextView) findViewById(R.id.login_p_signup_bottom);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_i = new Intent (getApplicationContext(),HomeActivity.class);
                startActivity(intent_i);
                Toast toast = Toast.makeText(MainActivity.this,"Log In Successfully",Toast.LENGTH_LONG);
                toast.show();
            }
        });

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getApplicationContext(),RegistorActivity.class);
                startActivity(intent);
            }
        });

        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getApplicationContext(),RegistorActivity.class);
                startActivity(intent);
            }
        });
    }
}