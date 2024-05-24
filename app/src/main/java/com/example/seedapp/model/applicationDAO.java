package com.example.seedapp.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.seedapp.db.DBHelper;

import java.sql.Date;

public class applicationDAO {
    private DBHelper dbHelper;

    public applicationDAO(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void insert(applicationDTO application) {
        SQLiteDatabase db = dbHelper.openWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("email", application.getEmail());
        values.put("annid", application.getAnnid());
        values.put("aplctdate", application.getAplctdate().toString());
        values.put("state", application.getState());

        db.insert("application", null, values);
        db.close();
    }

    public void delete(String email, String annid) {
        SQLiteDatabase db = dbHelper.openWritableDatabase();
        db.delete("application", "email = ? AND annid = ?", new String[]{email, annid});
        db.close();
    }

    public void update(applicationDTO application) {
        SQLiteDatabase db = dbHelper.openWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("aplctdate", application.getAplctdate().toString());
        values.put("state", application.getState());

        db.update("application", values, "email = ? AND annid = ?", new String[]{application.getEmail(), application.getAnnid()});
        db.close();
    }

    public applicationDTO select(String email, String annid) {
        SQLiteDatabase db = dbHelper.openReadableDatabase();
        Cursor cursor = db.query("application", null, "email = ? AND annid = ?", new String[]{email, annid}, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            applicationDTO application = new applicationDTO();
            application.setEmail(cursor.getString(cursor.getColumnIndexOrThrow("email")));
            application.setAnnid(cursor.getString(cursor.getColumnIndexOrThrow("annid")));
            application.setAplctdate(Date.valueOf(cursor.getString(cursor.getColumnIndexOrThrow("aplctdate"))));
            application.setState(cursor.getString(cursor.getColumnIndexOrThrow("state")));
            cursor.close();
            db.close();
            return application;
        } else {
            if (cursor != null) cursor.close();
            db.close();
            return null;
        }
    }
}
