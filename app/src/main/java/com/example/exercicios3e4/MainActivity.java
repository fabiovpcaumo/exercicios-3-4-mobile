package com.example.exercicios3e4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.exercicios3e4.services.LoginService;
import com.example.exercicios3e4.services.SignUpService;

public class MainActivity extends AppCompatActivity {

    EditText usernameInput, passwordInput;
    Button btnLogin, btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LoginService ls = new LoginService(getApplicationContext());

        usernameInput = findViewById(R.id.usernameInput);
        passwordInput = findViewById(R.id.passwordInput);
        btnLogin = findViewById(R.id.loginButton);
        btnSignUp = findViewById(R.id.signUpButton);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TO-DO Login
                ls.doLogin(usernameInput.getText().toString(), passwordInput.getText().toString());
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TO-DO Ir à página de SignUp
            }
        });


    }
}
