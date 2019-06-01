package com.example.exercicios3e4.services;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.exercicios3e4.services.SessionManager;
import com.example.exercicios3e4.services.utils.ConstantsUtil;

import org.w3c.dom.Text;

public class LoginService {
    private Context context;
    private SessionManager sm;
    private ConstantsUtil constants = new ConstantsUtil();

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    public LoginService(Context context){
        this.context = context;
        pref = context.getSharedPreferences(constants.getPrefFile(), constants.getPrivateMode());
        editor = pref.edit();
        sm = new SessionManager(context);
    }

    public boolean doLogin(String username, String password){
        if(sm.checkLogin()) return true;

        String expectedUsername = pref.getString("username", null);
        String expectedPassword = pref.getString("password", null);

        if(TextUtils.equals(username, expectedUsername) && TextUtils.equals(password, expectedPassword)){
           Toast.makeText(context, "Usuário logado com sucesso.", Toast.LENGTH_SHORT).show();
           sm.createLoginSession(username, password);
           return true;
        }

        Toast.makeText(context, "Usuário ou senha incorretos.", Toast.LENGTH_SHORT).show();
        return false;
    }
}

