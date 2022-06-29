package kr.board.entity;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Data;
// 인증후 사용자 정보를 저장하기 - ③ (UserDetails)
@Data
public class MemberUser extends User{ // UserDetails

	private Member member;
	
	public MemberUser(String username, String password,
			          Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		// TODO Auto-generated constructor stub
	}
	public MemberUser(Member mvo) {
        super(mvo.getMemID(), mvo.getMemPassword(), mvo.getAuthList().stream()
       	      .map(auth->new SimpleGrantedAuthority(auth.getAuth())).
       	      collect(Collectors.toList()));
        this.member=mvo; 	
        // List<AuthVO> -> Collection<SimpleGrantedAuthority>
    }
}
