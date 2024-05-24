package com.example.seedapp.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.seedapp.db.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class userDAO {
    private DBHelper dbHelper;

    public userDAO(Context context) {
        dbHelper = new DBHelper(context);
    }

    public long insert(userDTO user) {
        SQLiteDatabase db = dbHelper.openWritableDatabase();
        String sql = "INSERT INTO user (email, passwd, name, sex, phonenumber, location, mode, totaltime) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        db.execSQL(sql, new Object[]{user.getEmail(), user.getPasswd(), user.getName(), user.getSex(), user.getPhonenumber(), user.getLocation(), user.getMode(), user.getTotaltime()});
        db.close();
        return 1; // This is a placeholder; in reality, you might want to return a success/failure flag or the ID of the new row.
    }

    public long delete(String email) {
        SQLiteDatabase db = dbHelper.openWritableDatabase();
        String sql = "DELETE FROM user WHERE email = ?";
        db.execSQL(sql, new Object[]{email});
        db.close();
        return 1;
    }

    public long update(userDTO user) {
        SQLiteDatabase db = dbHelper.openWritableDatabase();
        String sql = "UPDATE user SET passwd = ?, name = ?, sex = ?, phonenumber = ?, location = ?, mode = ?, totaltime = ? WHERE email = ?";
        db.execSQL(sql, new Object[]{user.getPasswd(), user.getName(), user.getSex(), user.getPhonenumber(), user.getLocation(), user.getMode(), user.getTotaltime(), user.getEmail()});
        db.close();
        return 1;
    }

//    public userDTO select(String email) {
//        SQLiteDatabase db = dbHelper.openReadableDatabase();
//        String sql = "SELECT * FROM user WHERE email = ?";
//        if(email.equals("")) {
//            sql = "SELECT * FROM user";
//        }
//        Cursor cursor = db.rawQuery(sql, new String[]{email});
//        if (cursor != null && cursor.moveToFirst()) {
//            userDTO user = new userDTO();
//            user.setEmail(cursor.getString(cursor.getColumnIndexOrThrow("email")));
//            user.setPasswd(cursor.getString(cursor.getColumnIndexOrThrow("passwd")));
//            user.setName(cursor.getString(cursor.getColumnIndexOrThrow("name")));
//            user.setSex(cursor.getString(cursor.getColumnIndexOrThrow("sex")));
//            user.setPhonenumber(cursor.getString(cursor.getColumnIndexOrThrow("phonenumber")));
//            user.setLocation(cursor.getString(cursor.getColumnIndexOrThrow("location")));
//            user.setMode(cursor.getInt(cursor.getColumnIndexOrThrow("mode")));
//            user.setTotaltime(cursor.getInt(cursor.getColumnIndexOrThrow("totaltime")));
//            cursor.close();
//            db.close();
//            return user;
//        } else {
//            if (cursor != null) cursor.close();
//            db.close();
//            return null;
//        }
//    }

    public List<userDTO> select(String email) {
        SQLiteDatabase db = dbHelper.openReadableDatabase();
        String sql;
        if (email.equals("")) {
            sql = "SELECT * FROM user";
        } else {
            sql = "SELECT * FROM user WHERE email = ?";
        }

        Cursor cursor;
        if (email.equals("")) {
            cursor = db.rawQuery(sql, null); // 매개변수를 사용하지 않는 경우에는 null로 설정
        } else {
            cursor = db.rawQuery(sql, new String[]{email}); // 이메일을 매개변수로 전달
        }

        List<userDTO> userList = new ArrayList<>();

        if (cursor != null && cursor.moveToFirst()) {
            do {
                userDTO user = new userDTO();
                user.setEmail(cursor.getString(cursor.getColumnIndexOrThrow("email")));
                user.setPasswd(cursor.getString(cursor.getColumnIndexOrThrow("passwd")));
                user.setName(cursor.getString(cursor.getColumnIndexOrThrow("name")));
                user.setSex(cursor.getString(cursor.getColumnIndexOrThrow("sex")));
                user.setPhonenumber(cursor.getString(cursor.getColumnIndexOrThrow("phonenumber")));
                user.setLocation(cursor.getString(cursor.getColumnIndexOrThrow("location")));
                user.setMode(cursor.getInt(cursor.getColumnIndexOrThrow("mode")));
                user.setTotaltime(cursor.getInt(cursor.getColumnIndexOrThrow("totaltime")));

                userList.add(user);
            } while (cursor.moveToNext());
        }

        if (cursor != null) cursor.close();
        db.close();

        return userList;
    }

}
