package com.ohgiraffers.jpatest.member.repository;

import com.ohgiraffers.jpatest.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
