package efood.com.mvp_sqlite.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import efood.com.mvp_sqlite.Model.User;

/**
 * Created by loc on 27/04/2016.
 */
public class LoginDao {
    SQLiteDatabase db;
    Context context;
    public LoginDao(Context context) {
        db = (new dbhelper(context)).getWritableDatabase();
    }
    /*
    *
    * CREATE TABLE "USER_TABLE" " +
                    "(\"ID\" INTEGER PRIMARY KEY , " +
                    "\"USER_NAME\" TEXT, \"PASSWORD\" TEXT, " +
                    "\"ROLEID\" INTEGER)"*/
    public long Insert(User user) {
        ContentValues values = new ContentValues();
        values.put("USER_NAME", user.getUsername());
        values.put("PASSWORD", user.getPassword());
        values.put("ROLEID", user.getRoleId());
        return db.insert("USER_TABLE", null, values);
    }
    public boolean Login(String username, String password) {
        User user = new User();
        String Select = "Select * from  USER_TABLE where USER_NAME = '"
                + username + "' and PASSWORD  = '" + password + "'";
        Cursor cursor = db.rawQuery(Select, null);
        if (cursor.moveToFirst()) {
            do {

                user.setPassword(cursor.getString(cursor.getColumnIndex("PASSWORD")));
                Log.d("SSSSSSSS", cursor.getString(cursor.getColumnIndex("PASSWORD")));

                user.setUsername(cursor.getString(cursor.getColumnIndex("USER_NAME")));

            } while (cursor.moveToNext());
        }

        if (user.getPassword() != null && user.getUsername() != null) return true;
        return false;
    }

    public ArrayList<User> list() {
        ArrayList<User> list = new ArrayList<>();
        String Select = "Select * from USER_TABLE";
        Cursor cursor = db.rawQuery(Select, null);
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setPassword(cursor.getString(cursor.getColumnIndex("PASSWORD")));
                user.setUsername(cursor.getString(cursor.getColumnIndex("USER_NAME")));
                user.setId(cursor.getInt(cursor.getColumnIndex("ID")));
                user.setRoleId(cursor.getInt(cursor.getColumnIndex("ROLEID")));
                list.add(user);
            } while (cursor.moveToNext());
        }
        return list;
    }
}

