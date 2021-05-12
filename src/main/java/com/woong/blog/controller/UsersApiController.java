package com.woong.blog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.woong.blog.DTO.ResponseDto;
import com.woong.blog.model.RoleType;
import com.woong.blog.model.Users;
import com.woong.blog.service.UsersService;

@RestController
public class UsersApiController {

	@Autowired // Di가능 스프링이 컴파운드 스캔할 때 서비스 어노테이션이 된 클래스를 보는 순간 빈에 등록을 해주기때문
	private UsersService usersService; // 서비스 의존성 주입

	
	//세션-> 사용자의 정보가 서버에 저장
	
	
	
	@PostMapping("/auth/joinUser")
	public ResponseDto<Integer> save(@RequestBody Users users) { // 이름, 비밀번호, 이메일
		System.out.println("UsersApiController : save 호출");
		// 실제로 DB에 insert하고 아래에서 return 하면된다.
		
		
		users.setRole(RoleType.USERS);
		usersService.join(users);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); // 자바오브젝트를 json으로 변환해서 리턴(jackson), result가 1이면 성공 -1이면 실패
	}
/*
	@PostMapping("/api/temp/login")
	public ResponseDto<Integer> enter(@RequestBody Users users, HttpSession session) {

		System.out.println("UsersApiController : login 호출");
		Users principal = usersService.login(users);

		if (accessor != null)
			session.invalidate(); // 세션 초기화
			session.setAttribute("principal", principal);

		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
*/
}