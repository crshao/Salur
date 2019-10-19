package Models;

import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class UserAccess {
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    private static UserAccess INSTANCE = null;

    private UserAccess(SharedPreferences prefs){
        this.prefs = prefs;
        this.editor = prefs.edit();
    }

    public static synchronized UserAccess getInstance(SharedPreferences prefs){
        if(INSTANCE==null){
            INSTANCE = new UserAccess(prefs);
        }
        return INSTANCE;
    }

    public void saveUser(User user){
        Log.w("UserAcc",user.toString());
        ArrayList<User> userlist;
        if(getUser()!=null){
            userlist = getUser();
        }
        else{
            userlist = new ArrayList<>();
        }
        userlist.add(user);
        Gson gson = new Gson();
        String json = gson.toJson(userlist);
        editor.remove("UserList").commit();
        editor.putString("UserList",json).commit();

//        editor.putString("Nama", user.getNama()).commit();
//        editor.putString("Email", user.getEmail()).commit();
//        editor.putString("Username", user.getUsername()).commit();
//        editor.putString("Password", user.getPassword()).commit();

    }

    public ArrayList<User> getUser(){
//        User user = new User();
//        user.setNama(prefs.getString("Nama", null));
//        user.setEmail(prefs.getString("Email", null));
//        user.setUsername(prefs.getString("Username", null));
//        user.setPassword(prefs.getString("Password", null));
//        return user;

        ArrayList<User> userList;
        Gson gson = new Gson();
        String json = prefs.getString("UserList","");
        Type type = new TypeToken<ArrayList<User>>() {}.getType();
        userList = gson.fromJson(json,type);

        return userList;
    }
}
