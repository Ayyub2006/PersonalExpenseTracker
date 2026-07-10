package com.ayyub.PersonalExpenseTracker.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.ayyub.PersonalExpenseTracker.entity.User;
import com.ayyub.PersonalExpenseTracker.repository.UserRepository;

@Component
public class SecurityUtil {

	private final UserRepository userRepository;
	
	public SecurityUtil(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User getLoggedInUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		String email = authentication.getName();
		
		return userRepository.findByEmail(email)
				.orElseThrow(() -> new RuntimeException("User Not Found"));
	}
}
