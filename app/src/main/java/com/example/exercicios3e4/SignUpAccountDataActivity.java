package com.example.exercicios3e4;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.exercicios3e4.services.FirulaService;

import org.w3c.dom.Text;

public class SignUpAccountDataActivity extends AppCompatActivity {
    EditText usernameInput, passwordInput;
    Button btnSaveAccData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_account_data);
        final FirulaService fs = new FirulaService(this);
        final Context context = this;
        Intent intent = getIntent();
        String usernameFromIntent = intent.getStringExtra("username");

        usernameInput = findViewById(R.id.usernameInput);
        if(!TextUtils.isEmpty(usernameFromIntent)){
            usernameInput.setText(usernameFromIntent);
        }

        passwordInput = findViewById(R.id.passwordInput);

        btnSaveAccData = findViewById(R.id.btnSaveAccData);
        btnSaveAccData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();
                if(checkInput(username) && checkInput(password)){
                    fs.insertAccountData(username, password);
                    Toast.makeText(context, "Dados da conta inseridos com sucesso.", Toast.LENGTH_SHORT).show();
                    setResult(RESULT_OK);
                    finish();
                }else{
                    Toast.makeText(context, "Dados da conta inválidos.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean checkInput(String input){
        return !TextUtils.isEmpty(input);
    }
}
