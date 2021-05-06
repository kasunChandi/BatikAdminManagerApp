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
    public static  final String TABLENAME2 ="BatikPurchaseData";
    public static  final String col1 ="Id";
    public static  final String col2 ="SALES";
    public static  final String col3 ="TYPE";
    public static  final String col4 ="QTY";
    public static  final String col5 ="UPRICE";
    public static  final String col01 ="PId";
    public static  final String col02 ="PURCHASE";
    public static  final String col03 ="PTYPE";
    public static  final String col04 ="QTY";
    public static  final String col05 ="UPRICE";
    public static  final String col06 ="ITEMNAME";

    public DBConnection(@Nullable Context context) {
        super(context, DATABASENAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String createTable = "CREATE TABLE " +TABLENAME + "(Id INTEGER PRIMARY KEY AUTOINCREMENT, " + "SALES TEXT,TYPE TEXT, QTY TEXT,  UPRICE TEXT)";
        db.execSQL(createTable);
        String createTable2 = "CREATE TABLE " +TABLENAME2 + "(PId INTEGER PRIMARY KEY AUTOINCREMENT, " + "PURCHASE TEXT,PTYPE TEXT, QTY TEXT,  UPRICE TEXT, ITEMNAME TEXT)";
        db.execSQL(createTable2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF  EXISTS " + TABLENAME);
        db.execSQL("DROP TABLE IF  EXISTS " + TABLENAME2);
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

    public  boolean addPurData (String  Purchase, String Ptype, String Qty, String Uprice, String Iname){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues1 = new ContentValues();
        contentValues1.put(col02,Purchase);
        contentValues1.put(col03,Ptype);
        contentValues1.put(col04,Qty);
        contentValues1.put(col05,Uprice);
        contentValues1.put(col06,Iname);

        long result = db.insert(TABLENAME2, null, contentValues1);

        if(result == -1){
            return false;
        }
        else {
            return  true;
        }

    }


}
