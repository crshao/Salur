package com.example.salur.Manager;

import android.content.SharedPreferences;

import com.example.salur.Models.AccessToken;

public class TokenManager {
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    private static TokenManager INSTANCE = null;

    private TokenManager(SharedPreferences prefs){
        this.prefs = prefs;
        this.editor = prefs.edit();
    }

    public static synchronized TokenManager getInstance(SharedPreferences prefs){
        if(INSTANCE==null){
            INSTANCE = new TokenManager(prefs);
        }

        return INSTANCE;
    }

    public void saveToken(AccessToken token){
        editor.putString("ACCESS_TOKEN",token.getAccessToken()).commit();
        editor.putInt("ROLE",token.getRole()).commit();
    }

    public void deleteToken(){
        editor.remove("ACCESS_TOKEN").commit();
        editor.remove("ROLE").commit();
    }

    public AccessToken getToken(){
        AccessToken token = new AccessToken();
        token.setAccessToken(prefs.getString("ACCESS_TOKEN",null));
        token.setRole(prefs.getInt("ROLE",0));
        return token;
    }
}