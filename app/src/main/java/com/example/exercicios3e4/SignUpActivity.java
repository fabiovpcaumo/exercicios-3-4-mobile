package com.example.exercicios3e4;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.exercicios3e4.services.SignUpService;

public class SignUpActivity extends AppCompatActivity {

    EditText usernameInput, passwordInput;
    Button btnSignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        final Context context = this;
        final SignUpService ss = new SignUpService(this);

        usernameInput = findViewById(R.id.usernameInput);
        passwordInput = findViewById(R.id.passwordInput);
        btnSignUp = findViewById(R.id.signUpButton);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();
                if (checkInput(username) && checkInput(password)) {
                    ss.SignUp(username, password);
                    finish();
                }else{
                    Toast.makeText(context, "Usuário ou senha inválidos!", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

    public boolean checkInput(String input){
        boolean isCorrect;
        return isCorrect = TextUtils.isEmpty(input) ? false : true;

    }
}
