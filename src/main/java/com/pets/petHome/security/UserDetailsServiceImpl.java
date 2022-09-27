package com.pets.petHome.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pets.petHome.model.User;
import com.pets.petHome.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String eMail) throws UsernameNotFoundException {
		Optional<User> user = repository.findByEmail(eMail);
		user.orElseThrow(() -> new UsernameNotFoundException(eMail + "não encontrado!"));
		return user.map(UserDetailsImpl::new).get();
	}

}
