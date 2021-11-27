package com.example.fyp_b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistorActivity extends AppCompatActivity {

    TextView tv;
    EditText username,password,repassword,email;
    Button btn;
    DBHelper DB;
    Boolean check_user,check_email,insert;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registor);

        tv = (TextView) findViewById(R.id.signup_p_login_text);
        username = (EditText) findViewById(R.id.s_username);
        email = (EditText)findViewById(R.id.s_email);
        password = (EditText) findViewById(R.id.s_password);
        repassword = (EditText) findViewById(R.id.s_repassword);

        btn = (Button) findViewById(R.id.signup_s_btn);
        DB = new DBHelper(this);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if (user.equals("")||pass.equals("")||repass.equals("")) {
                    Toast.makeText(RegistorActivity.this, "Insert All Fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    if (pass.equals(repass)){
                        check_user = DB.checkuname(user);

                        if (check_user == false){
                            insert = DB.insertdata(user,pass);
                            if (insert== true){
                                Toast.makeText(RegistorActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(RegistorActivity.this, "Registration Faild", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(RegistorActivity.this, "User Exist", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(RegistorActivity.this, "Password Not Matched", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

    }}
