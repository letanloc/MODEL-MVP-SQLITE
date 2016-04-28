package efood.com.mvp_sqlite.Model;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

import efood.com.mvp_sqlite.Data.LoginDao;

/**
 * Created by loc on 27/04/2016.
 */
public class User {
    private int Id;
    private String Username;
    private String Password;
    private int RoleId;

    public User(int id, String username, String password, int roleId) {
        Id = id;
        Username = username;
        Password = password;
        RoleId = roleId;
    }

    public User() {


    }

    public User(String username, String password, int roleId) {
        Username = username;
        Password = password;
        RoleId = roleId;
    }

    Context context;
    LoginDao loginDao;

    public User(Context context) {
        this.context = context;
        loginDao = new LoginDao(context);
    }

    public boolean login(String username, String passwrod) {
        Log.e("SSSS", loginDao.Login(username, passwrod) + "");
        return loginDao.Login(username, passwrod);
    }
    public long Insert(User user) {
        return loginDao.Insert(user);
    }

    public ArrayList<User> LoadUser() {
        return loginDao.list();
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getRoleId() {
        return RoleId;
    }

    public void setRoleId(int roleId) {
        RoleId = roleId;
    }


}
