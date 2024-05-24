package com.example.seedapp.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.seedapp.db.DBHelper;

public class volunteeractivitiesDAO {
    private DBHelper dbHelper;

    public volunteeractivitiesDAO(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void insert(volunteeractivitiesDTO activities) {
        SQLiteDatabase db = dbHelper.openWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("email", activities.getEmail());
        values.put("actvtnotice", activities.getActvtnotice());
        values.put("state", activities.getState());
        values.put("vrecognitionhours", activities.getVrecognitionhours());

        db.insert("volunteer_activities", null, values);
        db.close();
    }

    public void delete(String email) {
        SQLiteDatabase db = dbHelper.openWritableDatabase();
        db.delete("volunteer_activities", "email = ?", new String[]{email});
        db.close();
    }

    public void update(volunteeractivitiesDTO activities) {
        SQLiteDatabase db = dbHelper.openWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("actvtnotice", activities.getActvtnotice());
        values.put("state", activities.getState());
        values.put("vrecognitionhours", activities.getVrecognitionhours());

        db.update("volunteer_activities", values, "email = ?", new String[]{activities.getEmail()});
        db.close();
    }

    public volunteeractivitiesDTO select(String email) {
        SQLiteDatabase db = dbHelper.openReadableDatabase();
        Cursor cursor = db.query("volunteer_activities", null, "email = ?", new String[]{email}, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            volunteeractivitiesDTO activities = new volunteeractivitiesDTO();
            activities.setEmail(cursor.getString(cursor.getColumnIndexOrThrow("email")));
            activities.setActvtnotice(cursor.getString(cursor.getColumnIndexOrThrow("actvtnotice")));
            activities.setState(cursor.getString(cursor.getColumnIndexOrThrow("state")));
            activities.setVrecognitionhours(cursor.getInt(cursor.getColumnIndexOrThrow("vrecognitionhours")));
            cursor.close();
            db.close();
            return activities;
        } else {
            if (cursor != null) cursor.close();
            db.close();
            return null;
        }
    }
}
