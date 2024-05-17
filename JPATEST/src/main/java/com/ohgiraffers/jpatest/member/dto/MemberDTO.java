package com.ohgiraffers.jpatest.member.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Getter
@Setter
@ToString
public class MemberDTO {
    private int memberNo;
    private int memberRole;
    private Date enrolledDate;
    private String address;
    private String memberId;
    public String memberPdw;
    private String memberName;
    private String phone;
    private String status;

}
