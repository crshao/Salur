package com.example.salur.Manager;

import com.google.gson.annotations.SerializedName;

public class DefaultResponse {
    @SerializedName("msg")
    private String msg;

    @SerializedName("code")
    private String code;

    public void setMsg(String msg){
        this.msg = msg;
    }

    public String getMsg(){
        return msg;
    }

    public void setCode(String code){
        this.code = code;
    }

    public String getCode(){
        return code;
    }

    @Override
    public String toString(){
        return
                "DefaultResponse{" +
                        "msg = '" + msg + '\'' +
                        ",code = '" + code + '\'' +
                        "}";
    }
}