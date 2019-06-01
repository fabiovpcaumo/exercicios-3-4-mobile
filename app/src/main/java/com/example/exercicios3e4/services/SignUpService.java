package com.example.exercicios3e4.services;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.example.exercicios3e4.services.utils.ConstantsUtil;

public class SignUpService {

    private ConstantsUtil constants = new ConstantsUtil();

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;

    public SignUpService(Context context){
        this.context = context;
        pref = context.getSharedPreferences(constants.getPrefFile(), constants.getPrivateMode());
        editor = pref.edit();

    }

    public void SignUp(String username, String password){
        editor.putString("username", username);
        editor.putString("password", password);
        editor.commit();
        Toast.makeText(context, "Usuário cadastrado com sucesso", Toast.LENGTH_SHORT).show();
    }
}
