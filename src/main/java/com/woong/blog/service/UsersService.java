package com.woong.blog.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.woong.blog.model.RoleType;
import com.woong.blog.model.Users;
import com.woong.blog.repository.UsersRepository;


// 스프링이 컴포넌트 스캔을 통해서 Bean에 등록해줌.ioc를 해준다
@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;
	private BCryptPasswordEncoder encoder;
	
	
	
	
	@Transactional // 회원가입 전체가 하나의 트랜잭션으로 묶임
	public void join(Users users) {
		String rawPassword = users.getPassword(); // 원문

		encoder = new BCryptPasswordEncoder();
		
		String encPassword = encoder.encode(rawPassword); // 해쉬  
		users.setRole(RoleType.USERS);
		users.setPassword(encPassword);
		usersRepository.save(users);
	}
	/*
	@Transactional 
	@org.springframework.transaction.annotation.Transactional(readOnly=true)
	public Users login(Users users) {
		return usersRepository.findByUsernameAndPassword(users.getUsername(), users.getPassword());
		
	}
	*/	
}
//ssssssssssssSSSSSssssssssssssssss