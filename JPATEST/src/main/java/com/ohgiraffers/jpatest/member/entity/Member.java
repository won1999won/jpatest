package com.ohgiraffers.jpatest.member.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "tbl_member")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberNo;
    private int memberRole;
    private Date enrolledDate;
    private String address;
    private String memberId;
    public String memberPdw;
    private String memberName;
    private String phone;
    private String status;

    public void modify(String memberName) {
    }
}
