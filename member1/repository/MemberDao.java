package com.mysite.member1.repository;

import java.util.HashMap;
import java.util.Map;
import com.mysite.member1.model.Member;

public class MemberDao {
	private Map<String, Member> mapDB = new HashMap<String, Member>();
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
}




