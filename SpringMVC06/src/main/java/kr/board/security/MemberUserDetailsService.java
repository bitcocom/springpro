package kr.board.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import kr.board.entity.Member;
import kr.board.entity.MemberUser;
import kr.board.mapper.MemberMapper;
// UserDetailsService - ②
public class MemberUserDetailsService implements UserDetailsService {

	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 로그인 처리 하기
		Member mvo=memberMapper.memLogin(username);
		//-->UserDetails -> implements--->User -> extends--->MemberUser
		if(mvo != null) {
			return new MemberUser(mvo); // new MemberUser(mvo); // Member, AuthVO
		}else {
	   	   throw new UsernameNotFoundException("user with username" + username + "does not exist."); 	
		}
	}

}
