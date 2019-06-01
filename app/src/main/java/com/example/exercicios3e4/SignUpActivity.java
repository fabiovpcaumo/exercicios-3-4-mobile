package com.example.exercicios3e4;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.exercicios3e4.services.FirulaService;
import com.example.exercicios3e4.services.SignUpService;

import java.util.List;

public class SignUpActivity extends AppCompatActivity {

    CheckBox isUserDataFulfilled, isAccountDataFulfilled;
    Button btnFillAccountData, btnFillUserData, btnSignUp;
    static final int IS_USER_DATA_FULFILLED = 1;
    static final int IS_ACCOUNT_DATA_FULFILLED = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        final Context context = this;
        final SignUpService ss = new SignUpService(this);
        final FirulaService fs = new FirulaService(this);

        isUserDataFulfilled = findViewById(R.id.isUserDataFulfilled);

        isAccountDataFulfilled = findViewById(R.id.isAccountDataFulfilled);

        btnFillAccountData = findViewById(R.id.btnFillAccountData);
        btnFillAccountData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SignUpAccountDataActivity.class);
                List<String> intentExtraContent = fs.retrieveAccountData();
                intent.putExtra("username", intentExtraContent.get(0));
                startActivityForResult(intent, IS_ACCOUNT_DATA_FULFILLED);
            }
        });

        btnFillUserData = findViewById(R.id.btnFillUserData);
        btnFillUserData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SignUpUserDataActivity.class);
                List<String> intentExtraContent = fs.retrieveUserData();
                intent.putExtra("userFirstName", intentExtraContent.get(0));
                intent.putExtra("userGender", intentExtraContent.get(1));
                startActivityForResult(intent, IS_USER_DATA_FULFILLED);
            }
        });

        btnSignUp = findViewById(R.id.signUpButton);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> result = fs.retrieveAccountData();

                if (!isAccountDataFulfilled.isChecked() || !isUserDataFulfilled.isChecked()){
                    Toast.makeText(context, "O cadastro não está preenchido corretamente.",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                if(checkAccountData(result)){
                    ss.SignUp(result.get(0), result.get(1));
                    finish();
                }
            }
        });


    }

    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == IS_ACCOUNT_DATA_FULFILLED && resultCode == RESULT_OK){
            isAccountDataFulfilled.setChecked(true);
        }

        if (requestCode == IS_USER_DATA_FULFILLED && resultCode == RESULT_OK){
            isUserDataFulfilled.setChecked(true);
        }
    }

    private boolean checkAccountData(List<String> accountData){
        return !(TextUtils.isEmpty(accountData.get(0)) && TextUtils.isEmpty(accountData.get(1)));
    }
}
