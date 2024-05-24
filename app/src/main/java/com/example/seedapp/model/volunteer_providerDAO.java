package com.example.seedapp.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.seedapp.db.DBHelper;

public class volunteer_providerDAO {
    private DBHelper dbHelper;

    public volunteer_providerDAO(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void insert(volunteer_providerDTO provider) {
        SQLiteDatabase db = dbHelper.openWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("email", provider.getEmail());
        values.put("actvtcontent", provider.getActvtcontent());
        values.put("vkind", provider.getVkind());
        values.put("repname", provider.getRepname());
        values.put("callnumber", provider.getCallnumber());
        values.put("vaddress", provider.getVaddress());

        db.insert("volunteer_provider", null, values);
        db.close();
    }

    public void delete(String email) {
        SQLiteDatabase db = dbHelper.openWritableDatabase();
        db.delete("volunteer_provider", "email = ?", new String[]{email});
        db.close();
    }

    public void update(volunteer_providerDTO provider) {
        SQLiteDatabase db = dbHelper.openWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("actvtcontent", provider.getActvtcontent());
        values.put("vkind", provider.getVkind());
        values.put("repname", provider.getRepname());
        values.put("callnumber", provider.getCallnumber());
        values.put("vaddress", provider.getVaddress());

        db.update("volunteer_provider", values, "email = ?", new String[]{provider.getEmail()});
        db.close();
    }

    public volunteer_providerDTO select(String email) {
        SQLiteDatabase db = dbHelper.openReadableDatabase();
        Cursor cursor = db.query("volunteer_provider", null, "email = ?", new String[]{email}, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            volunteer_providerDTO provider = new volunteer_providerDTO();
            provider.setEmail(cursor.getString(cursor.getColumnIndexOrThrow("email")));
            provider.setActvtcontent(cursor.getString(cursor.getColumnIndexOrThrow("actvtcontent")));
            provider.setVkind(cursor.getString(cursor.getColumnIndexOrThrow("vkind")));
            provider.setRepname(cursor.getString(cursor.getColumnIndexOrThrow("repname")));
            provider.setCallnumber(cursor.getString(cursor.getColumnIndexOrThrow("callnumber")));
            provider.setVaddress(cursor.getString(cursor.getColumnIndexOrThrow("vaddress")));
            cursor.close();
            db.close();
            return provider;
        } else {
            if (cursor != null) cursor.close();
            db.close();
            return null;
        }
    }
}
