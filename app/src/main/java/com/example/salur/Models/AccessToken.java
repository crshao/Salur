package com.example.salur.Models;

import com.google.gson.annotations.SerializedName;

public class AccessToken {
    @SerializedName("msg")
    private String msg;

    @SerializedName("code")
    private int code;

    @SerializedName("role")
    private int role;

    @SerializedName("token")
    private String token;

    public void setMsg(String msg){
        this.msg = msg;
    }

    public String getMsg(){
        return msg;
    }

    public void setCode(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public void setRole(int role){
        this.role = role;
    }

    public int getRole(){
        return role;
    }

    public void setAccessToken(String token){
        this.token = token;
    }

    public String getAccessToken(){
        return token;
    }

    @Override
    public String toString(){
        return
                "AccessToken{" +
                        "msg = '" + msg + '\'' +
                        ",code = '" + code + '\'' +
                        ",role = '" + role + '\'' +
                        ",token = '" + token + '\'' +
                        "}";
    }
}