package com.example.batikadminmanagerapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBConnection extends SQLiteOpenHelper
{
    public static  final String DATABASENAME ="BatikNew";
    public static  final String TABLENAME ="BatikSalesData";
    public static  final String col1 ="Id";
    public static  final String col2 ="SALES";
    public static  final String col3 ="TYPE";
    public static  final String col4 ="QTY";
    public static  final String col5 ="UPRICE";

    public DBConnection(@Nullable Context context) {
        super(context, DATABASENAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String createTable = "CREATE TABLE " +TABLENAME + "(Id INTEGER PRIMARY KEY AUTOINCREMENT, " + "SALES TEXT,TYPE TEXT, QTY TEXT,  UPRICE TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF  EXISTS " + TABLENAME);
        onCreate(db);

    }


    public  boolean addData (String  Sales, String Type, String Qty, String UPRICE){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col2,Sales);
        contentValues.put(col3,Type);
        contentValues.put(col4,Qty);
        contentValues.put(col5,UPRICE);

        long result = db.insert(TABLENAME, null, contentValues );

        if(result == -1){
            return false;
        }
        else {
            return  true;
        }

    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLENAME;
        Cursor data = db.rawQuery(query,null);
        return data;
    }


}
