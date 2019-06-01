package com.example.exercicios3e4.services;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.exercicios3e4.services.utils.ConstantsUtil;

public class SessionManager {

    private ConstantsUtil constants = new ConstantsUtil();

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    Context context;

    public SessionManager(Context context){
        this.context = context;
        pref = context.getSharedPreferences(constants.getPrefFile(), constants.getPrivateMode());
        editor = pref.edit();
    }

    public void createLoginSession(String username, String password){
        editor.putBoolean("isLoggedIn", true);
        editor.putString("loggedUsername", username);
        editor.putString("loggedPassword", password);
        editor.commit();

    }

    public boolean checkLogin(){
        if(pref.getBoolean("isLoggedIn", false)) return true;
        return false;
    }
}
