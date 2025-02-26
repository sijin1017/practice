package com.mysite.member1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.member1.model.Member;
import com.mysite.member1.repository.MemberDao;

@Service("changePwdSvc")
public class ChangePasswordService {
	private MemberDao memberDao;
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void changePassword(String email, String oldPass, String newPass) {
		// 해당 이메일이 존재하는지 여부 검사
		Member member = memberDao.selectByEmail(email);
		System.out.println("member : " + member);
		if(member == null) {
			System.out.println("해당 멤버가 없습니다.");
			return;
		}
		
		// 현재 비밀번호가 맞는지 검사
		if(!member.getPassword().equals(oldPass)) {
			System.out.println("현재 비밀번호가 맞지 않습니다.");
			return;
		}
		
		member.setPassword(newPass);
		memberDao.update(member);
	}
}








