package com.woong.blog.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.woong.blog.model.Users;

import lombok.Getter;

// 로그인이 완료되면 userdetails타입의 오브젝트를 스프링 시큐리디의 고유한 세션저장소에 저장


@Getter
public class PrincipalDetail implements UserDetails{
	private Users users;

    public PrincipalDetail(Users users) {
    	this.users=users;
    }
	

	@Override
	public String getPassword() {
	
		return users.getPassword();
	}

	@Override
	public String getUsername() {

		return users.getUsername();
	}

	// 계정이 만료되지 않았는지 리턴
	@Override
	public boolean isAccountNonExpired() {

		return true;
	}
	// 계정이 잠겨있지 않았는지 리턴
	@Override
	public boolean isAccountNonLocked() {

		return true;
	}
	// 비밀번호가 만료되지 않았는지 리턴
	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}
	// 계정이 활성화인지 리턴
	@Override
	public boolean isEnabled() {
	
		return true;
	}
	
	
	// 계정이 가지고 있는 목록을 리턴
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		Collection<GrantedAuthority> collectors = new ArrayList<>();
		collectors.add(()->{return "ROLE_"+users.getRole();});
		
		return collectors;
		
	}
}
