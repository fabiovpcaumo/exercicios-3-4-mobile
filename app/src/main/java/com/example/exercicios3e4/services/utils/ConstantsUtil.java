package com.example.exercicios3e4.services.utils;

public class ConstantsUtil {

    private static final String PREF_FILE = "AndroidHivePref";
    private static final String push_ = "AndroidHivePref";
    private static final int PRIVATE_MODE = 0;
    public ConstantsUtil(){

    }

    public static String getPrefFile() {
        return PREF_FILE;
    }

    public static String getPush_() {
        return push_;
    }

    public static int getPrivateMode() {
        return PRIVATE_MODE;
    }
}
