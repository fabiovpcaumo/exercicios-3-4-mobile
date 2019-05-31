package com.example.exercicios3e4.services;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.example.exercicios3e4.services.SessionManager;
import com.example.exercicios3e4.services.utils.ConstantsUtil;

public class LoginService {
    private Context context;
    private SessionManager sm = new SessionManager(context.getApplicationContext());
    private ConstantsUtil constants = new ConstantsUtil();

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    public LoginService(Context context){
        this.context = context;
        pref = _context.getSharedPreferences(constants.getPrefFile(), constants.getPrivateMode());
        editor = pref.edit();
    }

    public boolean doLogin(String username, String password){
        if(sm.checkLogin()) return true;

        if(username == pref.getString("username", null)){
           if(password == pref.getString("password", null)){
               Toast.makeText(_context, "Usuário logado com sucesso.", Toast.LENGTH_SHORT);
               sm.createLoginSession(username, password);
               return true;
           }
        }
            Toast.makeText(_context, "Usuário ou senha incorretos.", Toast.LENGTH_SHORT);
            return false;
    }
}

