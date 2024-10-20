package com.eventManagement.service.organizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.eventManagement.entities.Organizer;
import com.eventManagement.repository.OrganizerRepository;
import com.eventManagement.service.JwtService.JWTService;

@Service
public class OrganizerService {

	@Autowired
	private OrganizerRepository organizerRepository;
	
	@Autowired
	private JWTService jwtService;
	
	@Autowired
	private AuthenticationManager authManager;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	public Organizer registerOrganizer(Organizer organizer) {
		
		organizer.setPassword(this.encoder.encode(organizer.getPassword()));
		
		Organizer result = this.organizerRepository.save(organizer);
		return result;
	}

	public String verify(Organizer organizer) {
        try {
            Authentication authentication = this.authManager.authenticate(
                new UsernamePasswordAuthenticationToken(organizer.getEmail(), organizer.getPassword())
            );
            if (authentication.isAuthenticated()) {
                // Generate JWT token
                return jwtService.generateToken(authentication.getName());
            } else {
                throw new RuntimeException("Authentication failed");
            }
        } catch (AuthenticationException e) {
            throw new RuntimeException("Authentication failed", e);
        }
    }
	
}
