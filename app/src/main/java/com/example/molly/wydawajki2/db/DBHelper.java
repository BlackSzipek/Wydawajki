package com.example.molly.wydawajki2.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper
{
    private static final String DB_NAME="usersdb";
    private static final int DB_VERSION  = 1;
    //Table users
    public static final String TABLE_CNAME = "users";
    public static final String COL_CROWID = "crowid";
    public static final String COL_CNAME = "cname";
    public static final String COL_CPASS = "cpass";
    //Table house
    public static final String TABLE_DNAME = "house";
    public static final String COL_DROWID = "drowid";
    public static final String COL_DUSERID = "duserid";
    public static final String COL_DUSERSUM = "dusersum";
    public static final String COL_DDATE = "ddate";
    //table food
    public static final String TABLE_ENAME = "food";
    //table recreation
    public static final String TABLE_RNAME = "recreation";
    //table clothes
    public static final String TABLE_LNAME = "clothes";
    //table trips
    public static final String TABLE_TNAME = "trips";
    //table expenses
    public static final String TABLE_SNAME = "expenses";
    public static final String COL_DCAT = "dcat";


    String CREATE_CTABLE = "create table users(crowid INTEGER PRIMARY KEY AUTOINCREMENT," + "cname text , cpass text )";

    String CREATE_DTABLE ="CREATE TABLE house (drowid INTEGER PRIMARY KEY AUTOINCREMENT, duserid INT, dusersum DOUBLE, ddate TEXT )";
    String CREATE_ETABLE ="CREATE TABLE food (drowid INTEGER PRIMARY KEY AUTOINCREMENT, duserid INT, dusersum DOUBLE, ddate TEXT )";
    String CREATE_RTABLE ="CREATE TABLE recreation (drowid INTEGER PRIMARY KEY AUTOINCREMENT, duserid INT, dusersum DOUBLE, ddate TEXT )";
    String CREATE_LTABLE ="CREATE TABLE clothes (drowid INTEGER PRIMARY KEY AUTOINCREMENT, duserid INT, dusersum DOUBLE, ddate TEXT )";
    String CREATE_TTABLE ="CREATE TABLE trips (drowid INTEGER PRIMARY KEY AUTOINCREMENT, duserid INT, dusersum DOUBLE, ddate TEXT )";
    String CREATE_STABLE ="CREATE TABLE expenses (drowid INTEGER PRIMARY KEY AUTOINCREMENT, duserid INT, dcat TEXT, dusersum DOUBLE, ddate TEXT, cname TEXT )";

    //TO CREATE DATABASE
    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {try
    {
        db.execSQL(CREATE_CTABLE);
        db.execSQL(CREATE_DTABLE);
        db.execSQL(CREATE_ETABLE);
        db.execSQL(CREATE_RTABLE);
        db.execSQL(CREATE_LTABLE);
        db.execSQL(CREATE_TTABLE);
        db.execSQL(CREATE_STABLE);
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}
