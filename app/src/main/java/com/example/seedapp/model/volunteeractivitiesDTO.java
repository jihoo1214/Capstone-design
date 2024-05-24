package com.example.seedapp.model;

public class volunteeractivitiesDTO {

    // 사용자 이메일
    private String email;
    // 활동공고
    private String actvtnotice;
    // 상태
    private String state;
    // 봉사인정시간
    private int vrecognitionhours;

    // Getter and Setter methods

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getActvtnotice() {
        return actvtnotice;
    }

    public void setActvtnotice(String actvtnotice) {
        this.actvtnotice = actvtnotice;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getVrecognitionhours() {
        return vrecognitionhours;
    }

    public void setVrecognitionhours(int vrecognitionhours) {
        this.vrecognitionhours = vrecognitionhours;
    }
}
