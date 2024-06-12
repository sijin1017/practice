package com.mysite.member1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mysite.member1.model.Member;
import com.mysite.member1.model.RegisterRequest;
import com.mysite.member1.service.ChangePasswordService;
import com.mysite.member1.service.MemberRegisterService;

/*
 * exit
 * new 이메일 이름 암호 암호확인
 * change 이메일 현재암호 바꿀암호
 * list
 * info 이메일
 */

public class App {
	private static ApplicationContext ctx;
	
    public static void main( String[] args ) throws IOException{
    	ctx = new ClassPathXmlApplicationContext("config/application_context_config.xml");
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        App app = new App();
        
        while(true) {
        	System.out.println("명령어를 입력하세요 : ");
	        String command = br.readLine();
	        
	        if(command.equalsIgnoreCase("exit")) {
	        	System.out.println("프로그램을 종료합니다.");
	        	break;
	        }
	        else if(command.startsWith("new ")) {
	        	// 회원 가입
	        	app.newCommand(command.split(" "));
	        }
	        else if(command.startsWith("change ")) {
	        	// 회원 정보(암호) 수정
	        	app.changeCommand(command.split(" "));
	        }
	        else if(command.equalsIgnoreCase("list")) {
	        	// 전체 회원정보 조회
	        	app.listCommand();
	        } 
        } // end while
    } // end main
    
    public void newCommand(String[] commands) {
    	RegisterRequest req = new RegisterRequest();
    	req.setEmail(commands[1]);
    	req.setName(commands[2]);
    	req.setPassword(commands[3]);
    	req.setPasswordConfirm(commands[4]);
    
    	MemberRegisterService regSvc = ctx.getBean("regSvc", MemberRegisterService.class);
    	regSvc.register(req);        	
    }
    
    public void changeCommand(String[] commands) {
    	ChangePasswordService changePwdSvc = ctx.getBean("changePwdSvc", ChangePasswordService.class);
    	changePwdSvc.changePassword(commands[1], commands[2], commands[3]);
    	System.out.println("암호를 변경하였습니다.");
    }
    
    public void listCommand() {
    	MemberRegisterService regSvc = ctx.getBean("regSvc", MemberRegisterService.class);
    	Collection<Member> member = regSvc.selectAll();
    	for(Member mem : member) {
    		System.out.println(mem.getId() + "\t" + mem.getName() + "\t" +
    				mem.getEmail() + "\t" + mem.getRegisterDate() +
    				mem.getPassword());
    	}
    }
}






