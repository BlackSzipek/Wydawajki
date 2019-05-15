package com.example.molly.wydawajki2.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class ExpensesClass
{
    DBHelper dbHelper;
    SQLiteDatabase sqLiteDatabase;

    public ExpensesClass (Context context)
    {
        dbHelper = new DBHelper(context);
    }

    public void openDB()
    {
        sqLiteDatabase = dbHelper.getWritableDatabase();
        Log.d("jest", "dtable");

    }

    public void closeDB()
    {
        sqLiteDatabase.close();
    }

    public void insertRecord(Integer duserid, String dcat, Double dusersum,String ddate, String cname)
    {
        ContentValues contentValues =  new ContentValues();
        contentValues.put(DBHelper.COL_DUSERID,duserid);
        contentValues.put(DBHelper.COL_DCAT,dcat);
        contentValues.put(DBHelper.COL_DUSERSUM,dusersum);
        contentValues.put(DBHelper.COL_DDATE,ddate);
        contentValues.put(DBHelper.COL_CNAME,cname);
        sqLiteDatabase.insert(DBHelper.TABLE_SNAME,null,contentValues);
        Log.d("jest", "wpisano do expenses");
    }

    public Cursor getAllRecords()
    {
        Log.d("jest", "wypisujenmy");
        return sqLiteDatabase.rawQuery("select * from "+DBHelper.TABLE_SNAME,null);

    }

    public void deleteAllFoodExpenses()
    {
        sqLiteDatabase.delete(DBHelper.TABLE_SNAME,null,null);
    }

    public Cursor getSumAndDate(Integer userid)
    {
        Log.d("jest", "suma+data");
        return sqLiteDatabase.rawQuery("select "+DBHelper.COL_DUSERSUM+","+DBHelper.COL_DDATE+" from "+DBHelper.TABLE_SNAME
                +" where "+DBHelper.COL_DUSERID+"="+userid,null);

    }
    public Cursor getSumOfExpenses(Integer userid)
    {
        Log.d("jest", "suma");
        return sqLiteDatabase.rawQuery("select SUM("+DBHelper.COL_DUSERSUM+") "+" from "+DBHelper.TABLE_SNAME
                +" where "+DBHelper.COL_DUSERID+"="+userid,null);

    }

    public Cursor getUserOfName(Integer userid,String cname)
    {
        Log.d("jest", "wydatki innego użytkownika");
        return sqLiteDatabase.rawQuery("select "+DBHelper.COL_DUSERSUM+","+DBHelper.COL_DCAT+","+DBHelper.COL_DDATE+","+DBHelper.COL_CNAME
                +" from "+DBHelper.TABLE_SNAME
                +" where "+DBHelper.COL_DUSERID+"="+userid+" and "+DBHelper.COL_CNAME+"='"+cname+"'",null);

    }

}
