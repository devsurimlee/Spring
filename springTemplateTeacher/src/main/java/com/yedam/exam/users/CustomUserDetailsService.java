package com.yedam.exam.users;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

//인증 , 인가 확인 서비스
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired UserDAO dao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO vo = new UserVO();
		vo.setId(username);
		vo = dao.getUser(vo); 
		if (vo == null) {
			throw new UsernameNotFoundException("no user"); // 사용자가 존재하지 않는 경우
		}
		//권한 지정, 롤이 여러개일수가 있기 때문에 리스트로 받음 -> vo로 이동
//		List<GrantedAuthority> auth = new ArrayList<>();
//		auth.add(new SimpleGrantedAuthority(vo.getRole()));
		return vo;
	}


	public Collection<GrantedAuthority> getAuthorities(String username) {
		List<Authority> authList = dao.getRoles(username);
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (Authority authority : authList) {
			authorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
		}
		return authorities;
	}

}
