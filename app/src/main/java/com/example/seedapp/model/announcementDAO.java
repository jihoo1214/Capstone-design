package com.example.seedapp.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.seedapp.db.DBHelper;

public class announcementDAO {
    private DBHelper dbHelper;

    public announcementDAO(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void insert(announcementDTO announcement) {
        SQLiteDatabase db = dbHelper.openWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("annid", announcement.getAnnid());
        values.put("title", announcement.getTitle());
        values.put("content", announcement.getContent());
        values.put("vtime", announcement.getVtime());
        values.put("address", announcement.getAddress());
        values.put("recruits", announcement.getRecruits());
        values.put("vperiod", announcement.getVperiod());
        values.put("rperiod", announcement.getRperiod());
        values.put("checkscrab", announcement.isCheckscrab());
        values.put("applieduser", announcement.getApplieduser());
        values.put("callnumber", announcement.getCallnumber());

        db.insert("announcement", null, values);
        db.close();
    }

    public void delete(String annid) {
        SQLiteDatabase db = dbHelper.openWritableDatabase();
        db.delete("announcement", "annid = ?", new String[]{annid});
        db.close();
    }

    public void update(announcementDTO announcement) {
        SQLiteDatabase db = dbHelper.openWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title", announcement.getTitle());
        values.put("content", announcement.getContent());
        values.put("vtime", announcement.getVtime());
        values.put("address", announcement.getAddress());
        values.put("recruits", announcement.getRecruits());
        values.put("vperiod", announcement.getVperiod());
        values.put("rperiod", announcement.getRperiod());
        values.put("checkscrab", announcement.isCheckscrab());
        values.put("applieduser", announcement.getApplieduser());
        values.put("callnumber", announcement.getCallnumber());

        db.update("announcement", values, "annid = ?", new String[]{announcement.getAnnid()});
        db.close();
    }

    public announcementDTO select(String annid) {
        SQLiteDatabase db = dbHelper.openReadableDatabase();
        Cursor cursor = db.query("announcement", null, "annid = ?", new String[]{annid}, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            announcementDTO announcement = new announcementDTO();
            announcement.setAnnid(cursor.getString(cursor.getColumnIndexOrThrow("annid")));
            announcement.setTitle(cursor.getString(cursor.getColumnIndexOrThrow("title")));
            announcement.setContent(cursor.getString(cursor.getColumnIndexOrThrow("content")));
            announcement.setVtime(cursor.getInt(cursor.getColumnIndexOrThrow("vtime")));
            announcement.setAddress(cursor.getString(cursor.getColumnIndexOrThrow("address")));
            announcement.setRecruits(cursor.getInt(cursor.getColumnIndexOrThrow("recruits")));
            announcement.setVperiod(cursor.getString(cursor.getColumnIndexOrThrow("vperiod")));
            announcement.setRperiod(cursor.getString(cursor.getColumnIndexOrThrow("rperiod")));
            announcement.setCheckscrab(cursor.getInt(cursor.getColumnIndexOrThrow("checkscrab")) > 0);
            announcement.setApplieduser(cursor.getString(cursor.getColumnIndexOrThrow("applieduser")));
            announcement.setCallnumber(cursor.getString(cursor.getColumnIndexOrThrow("callnumber")));
            cursor.close();
            db.close();
            return announcement;
        } else {
            db.close();
            return null;
        }
    }
}
