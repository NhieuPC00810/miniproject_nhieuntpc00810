package com.example.demo;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.dao.AccountDAO;
import com.example.demo.entity.Accounts;
import com.example.demo.service.AccountsService;
import com.example.demo.service.ParamService;
import com.example.demo.service.SessionService;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	AccountsService accountsService;

	@Autowired
	BCryptPasswordEncoder pEncoder;
	
	@Autowired
	ParamService paramService;
	
	@Autowired
	AccountDAO dao;
	
	@Autowired
	SessionService sessionService;

	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// Cung cấp nguồn dữ liệu đăng nhập
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(username -> {
			try {
				String urn=paramService.getString("username", "");
				Accounts user = dao.findByid(urn);
				sessionService.set("usn", user);
				Accounts u = sessionService.get("usn"); 
				System.out.println(u.getUsername());
				Accounts accounts = accountsService.findById(username);
				String password = accounts.getPassword(); // lấy ra password
				String[] roles = accounts.getAuthorities().stream().map(au -> au.getRole().getId())
						.collect(Collectors.toList()).toArray(new String[0]); // lấy ra các Id của role thu thập lại
																				// thành 1
				return User.withUsername(username).password(pEncoder.encode(password)).roles(roles).build();
			} catch (Exception e) {
				throw new UsernameNotFoundException(username + e);
			}
		});
	}

	// Phân quyền sử dụng
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().cors().disable();
		http.authorizeRequests().antMatchers("/order/**").authenticated().antMatchers("/assets/admin/**","/user/index","/role/index")
				.hasAnyRole("STAF", "DIRE").antMatchers("/rest/authorities").hasRole("DIRE").anyRequest().permitAll();

		http.formLogin().loginPage("/security/login/form") // form dang nhap
				.loginProcessingUrl("/security/login") // action
				.defaultSuccessUrl("/security/login/success", false).failureUrl("/security/login/error") // đăng nhập
																											// sai hoặc
				// lỗi
				.usernameParameter("username").passwordParameter("password"); // default [username] [password]

		http.rememberMe().tokenValiditySeconds(86400); // default [remember-me]

		http.exceptionHandling().accessDeniedPage("/security/unauthoried"); // truy xuất không hợp lệ, k đúng quyền

		http.logout().logoutUrl("/security/logoff").logoutSuccessUrl("/security/logoff/success");
	}

	// Cho phép truy xuất REST API từ bên ngoài (domain khác)
	@Override
	public void configure(WebSecurity web) throws Exception {
		
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
	}

}
