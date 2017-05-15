package org.tymfry.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.tymfry.dto.UserDto;
import org.tymfry.entity.Role;
import org.tymfry.entity.User;
import org.tymfry.repository.RoleRepository;
import org.tymfry.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	public void saveUser(UserDto userDto) {
		User user = new User();
		user.setUsername(userDto.getUsername());
		user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		user.setPasswordConfirm(bCryptPasswordEncoder.encode(userDto.getPasswordConfirm()));
		user.setEmail(userDto.getEmail());
		user.setRoles(new HashSet<>());
		Role userRole = roleRepository.findOne(1);
		user.getRoles().add(userRole);
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setEnbaled(true);
		
		
		userRepository.save(user);
		
	}
}
