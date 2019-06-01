package com.example.exercicios3e4.services;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.exercicios3e4.services.utils.ConstantsUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirulaService {

    public Context context;

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    private ConstantsUtil constants = new ConstantsUtil();

    public FirulaService(Context context){
        this.context = context;
        pref = context.getSharedPreferences(constants.getPrefFile(), constants.getPrivateMode());
        editor = pref.edit();
    }

    public void insertUserData(String userFirstName, String gender){
        editor.putString("userFirstName", userFirstName);
        editor.putString("userGender", gender);
        editor.putBoolean("userDataInserted", true);
        editor.commit();
    }

    public void insertAccountData(String username, String password){
        editor.putString("username", username);
        editor.putString("password", password);
        editor.putBoolean("accountDataInserted", true);
        editor.commit();
    }

    public boolean isUserDataInserted(){
        return pref.getBoolean("userDataInserted", false);
    }

    public boolean isAccountDataInserted(){
        return pref.getBoolean("accountDataInserted", false);
    }

    public List<String> retrieveUserData(){
        List<String> result = new ArrayList<>();

        String userFirstName = pref.getString("userFirstName", null);
        String userGender = pref.getString("userGender", null);

        result.addAll(Arrays.asList(userFirstName, userGender));
        return result;
    }

    public List<String> retrieveAccountData(){
        List<String> result = new ArrayList<>();

        String username = pref.getString("username", null);
        String password = pref.getString("password", null);

        result.addAll(Arrays.asList(username, password));
        return result;
    }
}
