package com.example.kartheek.dbexample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Kartheek on 11/13/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "USERDATA.db";
    public static final String TABLE_NAME = "usersTable";
    public static final String COL1 = "id";
    public static final String COL2 = "username";
    public static final String COL3 = "password";
    public static final String COL4 = "email";
    public static final String COL5 = "mobile";
    private static final int VERSION = 1;

    private String QUERY = "CREATE TABLE "+TABLE_NAME+"("+COL1+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COL2+" text,"+COL3+" text,"+COL4+" text,"+COL5+" text)";

    Context context;

    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, VERSION);

        this.context =  context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
}
