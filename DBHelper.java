package com.thebe_smith.betterbudget;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 6;
    public static final String DATABASE_NAME = "Logindb.db";

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE Users " +
    "(User_id INTEGER PRIMARY KEY," +"Name TEXT," +  "UserName TEXT," +   "Password TEXT," +   "Income INTEGER," + "Food INTEGER," + "Travel INTEGER," + "Entertainment INTEGER," + "Phone INTEGER," + "Email TEXT )";
  
    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS Users";

    public DBHelper(Context context) { super(context, DATABASE_NAME, null, DATABASE_VERSION); }

    public void onCreate(SQLiteDatabase db) {   db.execSQL(SQL_CREATE_ENTRIES);  }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {    onUpgrade(db, oldVersion, newVersion); }

}