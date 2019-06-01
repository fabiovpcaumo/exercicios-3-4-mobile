package com.example.exercicios3e4.services;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

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
        return pref.getBoolean("isLoggedIn", false);
    }

    public String getLoggedUsername(){
        return pref.getString("loggedUsername", null);
    }

    public boolean doLogoff(){
        if (checkLogin()) {
            editor.putBoolean("isLoggedIn", false);
            editor.putString("loggedUsername", null);
            editor.putString("loggedPassword", null);
            editor.commit();
            Toast.makeText(context, "Logging off...", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
}
