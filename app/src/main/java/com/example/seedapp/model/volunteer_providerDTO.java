package com.example.seedapp.model;

public class volunteer_providerDTO {
    // 이메일
    private String email;
    // 활동내용
    private String actvtcontent;
    // 봉사종류
    private String vkind;
    // 대표자명
    private String repname;
    // 전화번호
    private String callnumber;
    // 활동지역
    private String vaddress;

    // Getter and Setter methods

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getActvtcontent() {
        return actvtcontent;
    }

    public void setActvtcontent(String actvtcontent) {
        this.actvtcontent = actvtcontent;
    }

    public String getVkind() {
        return vkind;
    }

    public void setVkind(String vkind) {
        this.vkind = vkind;
    }

    public String getRepname() {
        return repname;
    }

    public void setRepname(String repname) {
        this.repname = repname;
    }

    public String getCallnumber() {
        return callnumber;
    }

    public void setCallnumber(String callnumber) {
        this.callnumber = callnumber;
    }

    public String getVaddress() {
        return vaddress;
    }

    public void setVaddress(String vaddress) {
        this.vaddress = vaddress;
    }
}
