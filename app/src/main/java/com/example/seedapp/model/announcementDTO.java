package com.example.seedapp.model;

import java.sql.Date;

public class announcementDTO {
    // 공고아이디
    String annid;
    // 공고제목
    String title;
    // 공고내용
    String content;
    // 봉사인정시간
    int vtime;
    // 봉사활동 주소
    String address;
    // 모집인원
    int recruits;
    // 봉사기간(일정)
    String vperiod;
    // 모집기간
    String rperiod;
    // 스크랩 여부
    boolean checkscrab;
    // 지원한 사용자(이 테이블에 있어야하는가 의문)
    String applieduser;
    // 전화번호
    String callnumber;



}
