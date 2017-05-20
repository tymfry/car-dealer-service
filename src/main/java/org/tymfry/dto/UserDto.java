package org.tymfry.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class UserDto {
	
	private int id;
	@NotEmpty(message = "Podaj nazwę użytkownika")
	@Size(min = 3, message = "Nazwa użytkownika musi mieć przynajmniej 3 znaki")
	private String username;
	@NotEmpty(message = "Podaj hasło")
	@Size(min = 5, message = "Hasło musi mieć co przynajmniej 5 znaków")
	private String password;
	@NotEmpty(message = "Potwierdz hasło")
	private String passwordConfirm;
	@NotEmpty(message = "Podaj email")
	@Email(message = "Podaj poprawny email")
	private String email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
