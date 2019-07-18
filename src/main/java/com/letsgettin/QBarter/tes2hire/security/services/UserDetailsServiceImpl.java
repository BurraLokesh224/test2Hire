package com.letsgettin.QBarter.tes2hire.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.letsgettin.QBarter.tes2hire.model.Register;
import com.letsgettin.QBarter.tes2hire.repository.RegisterRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    RegisterRepository registerRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String emailId)
            throws UsernameNotFoundException {
    	
        Register user = registerRepository.findByEmailId(emailId)
                	.orElseThrow(() -> 
                        new UsernameNotFoundException("User Not Found with -> username or email : " + emailId)
        );

        return UserPrinciple.build(user);
    }
}