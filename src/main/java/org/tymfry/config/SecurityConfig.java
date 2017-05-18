package org.tymfry.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests()
				.antMatchers("/", "/js/**", "/css/**", "/show-cars/1", "/show-cars/2", "/registration").permitAll()
				.antMatchers("/add-car/1", "/add-car/2").hasAuthority("ROLE_USER")
				.antMatchers("/show-cars/3", "/show-cars/4", "/show-all-cars-to-sell", "/add-car/3")
				.hasAuthority("ROLE_ADMIN").anyRequest().authenticated().and().csrf().disable().formLogin().permitAll()
				.loginPage("/login").defaultSuccessUrl("/").permitAll().and().logout().logoutUrl("/logout").permitAll();
	}

}
