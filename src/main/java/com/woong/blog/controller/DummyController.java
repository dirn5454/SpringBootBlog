package com.woong.blog.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;

import com.woong.blog.model.Users;
import com.woong.blog.repository.UsersRepository;

public class DummyController {
	
	UsersRepository usersRepository;
	
	@GetMapping("/dummy/users")
	public List<Users> list(){
		return usersRepository.findAll();
	}
	
	@GetMapping("/dummy/user")
	public Page<Users> pageList(@PageableDefault(size=2, sort="id", direction=Sort.Direction.DESC) Pageable pageable){
		
		Page<Users> pagingUser = usersRepository.findAll(pageable);
	    pagingUser.getContent();
		
		return pagingUser;
		
	}
}