package com.mysite.member1.service;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mysite.member1.model.Member;
import com.mysite.member1.model.RegisterRequest;
import com.mysite.member1.repository.MemberDao;

@Component("regSvc")
public class MemberRegisterService {
	private MemberDao memberDao;
	
	public MemberRegisterService() {}
	@Autowired
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void register(RegisterRequest req) {
		// 같은 이메일주소가 있는지 확인
		Member member = memberDao.selectByEmail(req.getEmail());
		if(member != null) {
			System.out.println("같은 이메일 주소가 있습니다.");
			return;
		}
		
		// 두개의 패스워드가 맞는지 확인
		if(!req.getPassword().equals(req.getPasswordConfirm())) {
			System.out.println("패스워드를 잘 못 입력하였습니다.");
			return;
		}
		
		Member newMem = new Member(req.getName(), req.getEmail(),
				req.getPassword(), new Date());
		memberDao.insert(newMem);
	}
	
	public Collection<Member> selectAll(){
		return memberDao.selectAll();
	}
}
