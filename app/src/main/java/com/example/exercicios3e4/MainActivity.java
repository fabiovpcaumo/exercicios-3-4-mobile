package com.example.exercicios3e4;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.exercicios3e4.services.LoginService;
import com.example.exercicios3e4.services.SessionManager;
import com.example.exercicios3e4.services.SignUpService;

public class MainActivity extends AppCompatActivity {

    EditText usernameInput, passwordInput;
    Button btnLogin, btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context context = this;
        final LoginService ls = new LoginService(context);
        final SessionManager sm = new SessionManager(context);

        usernameInput = findViewById(R.id.usernameInput);
        passwordInput = findViewById(R.id.passwordInput);
        btnLogin = findViewById(R.id.loginButton);
        btnSignUp = findViewById(R.id.signUpButton);

        if(sm.checkLogin()){
            Intent intent = new Intent(context, LoggedInActivity.class);
            startActivity(intent);
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ls.doLogin(usernameInput.getText().toString(), passwordInput.getText().toString())){
                    Intent intent = new Intent(context, LoggedInActivity.class);
                    startActivity(intent);
                }
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SignUpActivity.class);
                startActivity(intent);
            }
        });


    }
}
