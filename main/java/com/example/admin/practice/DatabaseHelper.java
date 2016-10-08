package com.example.admin.practice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Admin on 21-Sep-16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "DeviceInfo.db";
    public static final String TABLE_NAME ="DeviceList";
    public static final String COL_ID = "id";
    public static final String DEVICE_NAME = "name";
    public static final String COL_FRAME = "frame";
    public static final String COL_FLIGHT_CONTROLLER = "flight_cont";
    public static final String COL_MOTOR = "motor";
    public static final String COL_ESC = "esc";
    public static final String COL_BATTERY = "battery";
    public static final String COL_FPV = "fpv";
    public static final String COL_VTX = "vtx";
    public static final String NEWTABLE = "CREATE TABLE IF NOT EXISTS "
            + TABLE_NAME + "(" + DEVICE_NAME
            + " text primary key, " + COL_ID
            + " integer," + COL_FRAME
            + " text not null," + COL_FLIGHT_CONTROLLER+ " text not null,"  + COL_MOTOR + " text not null,"+ COL_ESC + " text not null,"+ COL_BATTERY + " text not null,"+ COL_FPV + " text not null," + COL_VTX +  " text not null);";
     Context context;
    SQLiteDatabase db = this.getWritableDatabase();






    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
        Log.d("Database","Database Created");

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(NEWTABLE);
        Log.d("Database", "Table Created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+ TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, String frame, String flight_cont, String motor, String esc, String battery, String fpv, String vtx){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DEVICE_NAME,name);
        contentValues.put(COL_FRAME,frame);
        contentValues.put(COL_FLIGHT_CONTROLLER,flight_cont);
        contentValues.put(COL_MOTOR,motor);
        contentValues.put(COL_ESC,esc);
        contentValues.put(COL_BATTERY,battery);
        contentValues.put(COL_FPV,fpv);
        contentValues.put(COL_VTX,vtx);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result == 1) {
             return false;
        }else {
            Log.d("Database","Values Inserted");
            db.close();
             return true;
              }


    }

    public Cursor getInformation(SQLiteDatabase db){
        String[] projection = {DEVICE_NAME, COL_FRAME,COL_FLIGHT_CONTROLLER,COL_MOTOR,COL_ESC,COL_BATTERY,COL_FPV,COL_VTX};
        Cursor cursor = db.query(TABLE_NAME,projection,null,null,null,null,null);
        return cursor;
            }





}

