package kr.board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

import kr.board.security.MemberUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    // 
	@Bean
	public UserDetailsService memberUserDetailsService() {
	   return new MemberUserDetailsService();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(memberUserDetailsService())
		.passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//요청에대한 보안 설정~~
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		http.addFilterBefore(filter,CsrfFilter.class);	
		// 요청에따른 권한을 확인하여 서비스 하는 부분 - ①
	    http
	         .authorizeRequests()
	              .antMatchers("/")
	              .permitAll()
	              .and()
	         .formLogin()
	              .loginPage("/memLoginForm.do")
	              .loginProcessingUrl("/memLogin.do")
	              .permitAll()
	              .and()
	         .logout()
	              .invalidateHttpSession(true)
	              .logoutSuccessUrl("/")
	              .and()
	         .exceptionHandling().accessDeniedPage("/access-denied");     
	}
	// 패스워드 인코딩 객체 설정
    @Bean 
    public PasswordEncoder passwordEncoder() {
		 return new BCryptPasswordEncoder(); 
    }
}
