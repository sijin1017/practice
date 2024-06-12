package com.mysite.member1.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.mysite.member1.model.Member;

@Component
public class MemberDao {
	private static Map<String, Member> mapDB = new HashMap<String, Member>();
	private static long nextId = 0;
	
	public void insert(Member member) {
		member.setId(++nextId);
		mapDB.put(member.getEmail(), member);
		System.out.println("mapDB : " + mapDB);
	}
	
	// 같은 이메일주소가 있는지 확인
	public Member selectByEmail(String email) {
		return mapDB.get(email);
	}
	
	// 전체 회원정보 조회
	public Collection<Member> selectAll(){
		return mapDB.values();
	}
	
	// 패스워드 수정
	public void update(Member member) {
		mapDB.put(member.getEmail(), member);
		System.out.println("mapDB 수정: " + mapDB);
	}
}




