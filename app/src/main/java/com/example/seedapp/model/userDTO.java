package com.example.seedapp.model;

public class userDTO {
    // 이메일
    private String email;
    // 비밀번호
    private String passwd;
    // 이름
    private String name;
    // 성별
    private String sex;
    // 전화번호
    private String phonenumber;
    // 활동지역
    private String location;
    // 봉사자, 봉사기관 구분
    private int mode;
    // 총 봉사시간
    private int totaltime;



    // 생성자
    public userDTO(String email, String passwd, String name, String sex, String phonenumber, String location, int mode, int totaltime) {
        this.email = email;
        this.passwd = passwd;
        this.name = name;
        this.sex = sex;
        this.phonenumber = phonenumber;
        this.location = location;
        this.mode = mode;
        this.totaltime = totaltime;
    }

    public userDTO() {

    }


    // Getter and Setter methods

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getTotaltime() {
        return totaltime;
    }

    public void setTotaltime(int totaltime) {
        this.totaltime = totaltime;
    }
}
