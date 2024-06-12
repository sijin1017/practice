package com.mysite.member1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.mysite.member1.model.RegisterRequest;
import com.mysite.member1.repository.MemberDao;
import com.mysite.member1.service.MemberRegisterService;

/*
 * new 이메일 이름 암호 암호확인
 * change 이메일 현재암호 바꿀암호
 */

public class App {
    public static void main( String[] args ) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MemberRegisterService regSvc = new MemberRegisterService();
        
        while(true) {
        	System.out.println("명령어를 입력하세요 : ");
	        String command = br.readLine();
	        
	        if(command.equalsIgnoreCase("exit")) {
	        	System.out.println("프로그램을 종료합니다.");
	        	break;
	        }
	        else if(command.startsWith("new ")) {
	        	// 회원 가입
	        	String[] commands = command.split(" ");
	        	
	        	RegisterRequest req = new RegisterRequest();
	        	req.setEmail(commands[1]);
	        	req.setName(commands[2]);
	        	req.setPassword(commands[3]);
	        	req.setPasswordConfirm(commands[4]);
	        	
	        	regSvc.register(req);        	
	        	
	        	continue;
	        }
	        else if(command.startsWith("change ")) {
	        	// 회원 정보(암호) 수정
	        	continue;
	        }
        }
    }
}
