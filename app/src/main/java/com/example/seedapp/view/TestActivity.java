package com.example.seedapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.seedapp.db.DBHelper;
import com.example.seedapp.R;
import com.example.seedapp.model.userDAO;
import com.example.seedapp.model.userDTO;

import java.util.List;

public class TestActivity extends AppCompatActivity {
    private DBHelper dbHelper;
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Button insert = (Button) findViewById(R.id.insert);
        Button update = (Button) findViewById(R.id.update);
        Button delete = (Button) findViewById(R.id.delete);
        Button select = (Button) findViewById(R.id.select);
        userDAO dao = new userDAO(this);



        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    long result = dao.insert(new userDTO("jihoo@gmail.com", "jihoo123", "박지후", "남자", "010-4614-3863", "동림용산로12", 0, 0));
                    // 삽입 성공
                } catch (SQLException e) {
                    // 삽입 실패
                    e.printStackTrace();
                }
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    long result = dao.update(new userDTO("jihoo@gmail.com", "young1234", "서영진", "남자", "010-4563-1234", "기아챔피언스앞", 0, 0));
                    // 삽입 성공
                } catch (SQLException e) {
                    // 삽입 실패
                    e.printStackTrace();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    long result = dao.delete("jihoo12145@gmail.com");
                    // 삽입 성공
                } catch (SQLException e) {
                    // 삽입 실패
                    e.printStackTrace();
                }
            }
        });

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<userDTO> userList = dao.select("");
                if (userList != null) {
                    for (userDTO user : userList) {
                        Log.d("UserData", "Email: " + user.getEmail() +
                                ", Name: " + user.getName() +
                                ", Sex: " + user.getSex() +
                                ", Phone: " + user.getPhonenumber() +
                                ", Location: " + user.getLocation() +
                                ", Mode: " + user.getMode() +
                                ", TotalTime: " + user.getTotaltime());
                    }
                } else {
                    Log.d("UserData", "No users found");
                }
            }
        });



    }

}