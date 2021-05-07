package com.woong.blog.config.auth;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.woong.blog.model.Users;
import com.woong.blog.repository.UsersRepository;

@Service
public class PrincipalDetailService implements UserDetailsService{

	@Autowired
	private UsersRepository usersRepository;
	
	// 스프링이 로그인 요청을 가로챌 때 username password 변수 2개를 가로채는데 password는 자동처리, username이 db에 있는지만 확인
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users principal = usersRepository.findByUsername(username)
				.orElseThrow(()->{
					return new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다.");				
				});
		return new PrincipalDetail(principal); // 시큐리티 세션에 유저 정보 저장
	}
}
