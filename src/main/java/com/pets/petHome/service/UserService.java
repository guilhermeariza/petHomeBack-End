package com.pets.petHome.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.pets.petHome.model.User;
import com.pets.petHome.model.UserLogin;
import com.pets.petHome.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public Optional<User> signupUser(User user){
		if(userRepository.findByEmail(user.getEmail()).isPresent()) {
			return Optional.empty();
		} else {
			user.setPassword(encryptPassword(user.getPassword()));
			userRepository.save(user);
			return Optional.of(user);
		}
	}
	
	public Optional<User> updateUser(User user){
		if(userRepository.findById(user.getId()).isPresent()) {
			Optional<User> searchUser = userRepository.findByEmail(user.getEmail());
			if((searchUser.isPresent()) && (searchUser.get().getId() != user.getId()))
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already exists!", null);
			user.setPassword(encryptPassword(user.getPassword()));
			return Optional.ofNullable(userRepository.save(user));
		}
		return Optional.empty();
	}
	
	public Optional<UserLogin> authenticateUser(Optional <UserLogin> userLogin){
		Optional<User> user = userRepository.findByEmail(userLogin.get().getEmailLogin());
		if(user.isPresent()) {
			if(comparePasswords(userLogin.get().getPasswordLogin(), user.get().getPassword())) {
				userLogin.get().setIdLogin(user.get().getId());
				userLogin.get().setNameLogin(user.get().getName());
				userLogin.get().setEmailLogin(user.get().getEmail());
				userLogin.get().setPasswordLogin(user.get().getPassword());
				System.out.println("Passou aqui");
				userLogin.get().setTokenLogin(generateBasicToken(userLogin.get().getEmailLogin(), userLogin.get().getPasswordLogin()));
				return userLogin;

			}
		}
		return Optional.empty();
	}
	
	private String encryptPassword(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}
	
	private boolean comparePasswords(String typedPassword, String dataBasePassword) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.matches(typedPassword, dataBasePassword);
	}
	
	private String generateBasicToken(String user, String password) {
		String token = user + ":" + password;
		byte[] tokenBase64 = Base64.encodeBase64(token.getBytes(Charset.forName("US-ASCII")));
		return "Basic " + new String(tokenBase64);
		
	}

}
