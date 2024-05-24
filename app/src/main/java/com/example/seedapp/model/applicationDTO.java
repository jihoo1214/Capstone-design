package com.example.seedapp.model;

import java.sql.Date;

public class applicationDTO {
    // 이메일
    private String email;
    // 공고 아이디
    private String annid;
    // 신청일자
    private Date aplctdate;
    // 상태
    private String state;

    // Getter and Setter methods

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAnnid() {
        return annid;
    }

    public void setAnnid(String annid) {
        this.annid = annid;
    }

    public Date getAplctdate() {
        return aplctdate;
    }

    public void setAplctdate(Date aplctdate) {
        this.aplctdate = aplctdate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
