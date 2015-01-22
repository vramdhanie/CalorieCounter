package com.thinkful.caloriecounter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Vincent on 1/22/15.
 */
public class CalorieDBHelper extends SQLiteOpenHelper{

    public CalorieDBHelper(Context context) {
        super(context, CalorieDBContract.DATABASE_NAME, null, CalorieDBContract.DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CalorieDBContract.SQL_CREATE_FOOD);
        db.execSQL(CalorieDBContract.SQL_CREATE_MEAL_TYPE);
        db.execSQL(CalorieDBContract.SQL_CREATE_MEAL);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(CalorieDBContract.SQL_DELETE_MEAL);
        db.execSQL(CalorieDBContract.SQL_DELETE_FOOD);
        db.execSQL(CalorieDBContract.SQL_DELETE_MEAL_TYPE);
        onCreate(db);
    }

}
