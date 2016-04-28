package efood.com.mvp_sqlite.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by loc on 27/04/2016.
 */
public class dbhelper extends SQLiteOpenHelper {
    public dbhelper(Context context) {
        super(context, "Data.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String TABLE_USER = "CREATE TABLE \"USER_TABLE\" " +
                "(\"ID\" INTEGER PRIMARY KEY  AUTOINCREMENT , " +
                "\"USER_NAME\" TEXT, \"PASSWORD\" TEXT, " +
                "\"ROLEID\" INTEGER)";
        db.execSQL(TABLE_USER);
        db.execSQL("insert into  USER_TABLE  values(1,'letanloc','letanloc',1)");
        db.execSQL("insert into  USER_TABLE  values(2,'admin','admin',2)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
