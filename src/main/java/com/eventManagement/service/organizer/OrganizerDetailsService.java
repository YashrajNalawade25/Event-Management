package com.eventManagement.service.organizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eventManagement.entities.Organizer;
import com.eventManagement.entities.OrganizerPrincipal;
import com.eventManagement.repository.OrganizerRepository;

//equivatent to MyUserDetailsService in teluskoSpringSecurity project
@Service
public class OrganizerDetailsService implements UserDetailsService {

    @Autowired
    private OrganizerRepository organizerRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Organizer user = this.organizerRepository.findByEmail(email);
        if (user == null) {
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("user not found");
        }
        
        return new OrganizerPrincipal(user);
    }
}
