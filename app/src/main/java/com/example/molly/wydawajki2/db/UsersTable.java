package com.example.molly.wydawajki2.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class UsersTable
{
    DBHelper dbHelper;
    SQLiteDatabase sqLiteDatabase;

    public UsersTable(Context context)
    {
        dbHelper = new DBHelper(context);
    }

    public void openDB()
    {
        sqLiteDatabase = dbHelper.getWritableDatabase();

    }

    public void closeDB()
    {
        sqLiteDatabase.close();
    }

    public Integer insertRecord(String cname, String cpass)
    {
        Cursor c=sqLiteDatabase.rawQuery("SELECT "+DBHelper.COL_CNAME+" FROM "+DBHelper.TABLE_CNAME+" WHERE "+DBHelper.COL_CNAME+"='"+cname+"'", null);
        if(c.moveToFirst())
        {
            Log.d("Rexist", "Juz jest w bazie");
            Cursor c1=sqLiteDatabase.rawQuery("SELECT "+DBHelper.COL_CROWID+" FROM "
                    +DBHelper.TABLE_CNAME+" WHERE "+DBHelper.COL_CNAME+"='"+cname+"'"+" AND "+DBHelper.COL_CPASS+"='"+cpass+"'", null);
            if(c1.moveToFirst())
            {
                Log.d("Rexist", "HASLO JEST GOOD");
                return 1;
            }
            else
            {
                Log.d("Rexist", "HASLO JEST BAD");
                return 2;
            }
        }
        else
        {
            Log.d("Noexist", "Nie ma");

            ContentValues contentValues =  new ContentValues();
            contentValues.put(DBHelper.COL_CNAME,cname);
            contentValues.put(DBHelper.COL_CPASS,cpass);
            sqLiteDatabase.insert(DBHelper.TABLE_CNAME,null,contentValues);
            return 3;
            //return false;
        }
    }

    public Cursor getAllRecords()
    {
        return sqLiteDatabase.rawQuery("select * from "+DBHelper.TABLE_CNAME,null);
    }

    public Integer getIdOfUser(String cname)
    {
        Cursor cursor;
        cursor = sqLiteDatabase.rawQuery("select * from "+DBHelper.TABLE_CNAME+" where  "+DBHelper.COL_CNAME+"='"+cname+"'",null);
        cursor.moveToFirst();
        Integer id = cursor.getInt(0);
        return id;

    }

    public Cursor getNames()
    {
        return sqLiteDatabase.rawQuery("select "+DBHelper.COL_CNAME+" from "+DBHelper.TABLE_CNAME,null);
    }

    public void deleteAllUsers()
    {
        sqLiteDatabase.delete(DBHelper.TABLE_CNAME,null,null);
    }
}
