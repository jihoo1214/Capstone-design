package com.example.seedapp.model;

import java.sql.Date;

public class announcementDTO {
    // 공고아이디
    private String annid;
    // 공고제목
    private String title;
    // 공고내용
    private String content;
    // 봉사인정시간
    private int vtime;
    // 봉사활동 주소
    private String address;
    // 모집인원
    private int recruits;
    // 봉사기간(일정)
    private String vperiod;
    // 모집기간
    private String rperiod;
    // 스크랩 여부
    private boolean checkscrab;
    // 지원한 사용자
    private String applieduser;
    // 전화번호
    private String callnumber;

    // Getter and Setter methods

    public String getAnnid() {
        return annid;
    }

    public void setAnnid(String annid) {
        this.annid = annid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getVtime() {
        return vtime;
    }

    public void setVtime(int vtime) {
        this.vtime = vtime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRecruits() {
        return recruits;
    }

    public void setRecruits(int recruits) {
        this.recruits = recruits;
    }

    public String getVperiod() {
        return vperiod;
    }

    public void setVperiod(String vperiod) {
        this.vperiod = vperiod;
    }

    public String getRperiod() {
        return rperiod;
    }

    public void setRperiod(String rperiod) {
        this.rperiod = rperiod;
    }

    public boolean isCheckscrab() {
        return checkscrab;
    }

    public void setCheckscrab(boolean checkscrab) {
        this.checkscrab = checkscrab;
    }

    public String getApplieduser() {
        return applieduser;
    }

    public void setApplieduser(String applieduser) {
        this.applieduser = applieduser;
    }

    public String getCallnumber() {
        return callnumber;
    }

    public void setCallnumber(String callnumber) {
        this.callnumber = callnumber;
    }
}
