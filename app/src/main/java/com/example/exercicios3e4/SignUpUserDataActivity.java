package com.example.exercicios3e4;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.exercicios3e4.services.FirulaService;

import org.w3c.dom.Text;

public class SignUpUserDataActivity extends AppCompatActivity {

    EditText userFirstNameInput;
    RadioGroup genderOptions;
    RadioButton radioButtonMasc, radioButtonFem, radioButtonPni;
    Button btnSaveUserData;
    private String userGender = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_user_data);

        final FirulaService fs = new FirulaService(this);
        final Context context = this;
        Intent intent = getIntent();

        String userFirstNameFromIntent = intent.getStringExtra("userFirstName");
        String userGenderFromIntent = intent.getStringExtra("userGender");

        userFirstNameInput = findViewById(R.id.userFirstNameInput);
        if(!TextUtils.isEmpty(userFirstNameFromIntent)){
            userFirstNameInput.setText(userFirstNameFromIntent);
        }

        genderOptions = findViewById(R.id.genderOptions);
        radioButtonMasc = findViewById(R.id.radioButtonMasc);
        radioButtonFem = findViewById(R.id.radioButtonFem);
        radioButtonPni = findViewById(R.id.radioButtonPni);

        genderOptions.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == radioButtonMasc.getId()) {
                    userGender = "Masculino";
                } else if (checkedId == radioButtonFem.getId()) {
                    userGender = "Feminino";
                } else if (checkedId == radioButtonPni.getId()) {
                    userGender = "Prefiro não Informar";
                }
            }
        });

        btnSaveUserData = findViewById(R.id.btnSaveUserData);
        btnSaveUserData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userFirstName = userFirstNameInput.getText().toString();

                if(checkInput(userFirstName) && checkInput(userGender)){
                    fs.insertUserData(userFirstName, userGender);
                    Toast.makeText(context, "Dados do usuário inseridos com sucesso.", Toast.LENGTH_SHORT).show();
                    setResult(RESULT_OK);
                    finish();
                }else{
                    Toast.makeText(context, "Dados do usuário inválidos.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean checkInput(String input){
        return !TextUtils.isEmpty(input);
    }
}

