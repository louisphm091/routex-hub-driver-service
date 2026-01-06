package com.ecommerce.server.auth.services;

import com.ecommerce.server.auth.entities.Authority;
import com.ecommerce.server.auth.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bao Pham
 * @created 07/04/2025
 * @project e-commerce application
 **/

@Service
public class AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    // Call to get Authorities List
    public List<Authority> getUserAuthority(){
        List<Authority> authorities=new ArrayList<>();
        Authority authority= authorityRepository.findByRoleCode("ADMIN");
        authorities.add(authority);
        System.out.println(authorities);
        return authorities;
    }
    public Authority createAuthority(String role, String description){
        Authority authority= Authority.builder().roleCode(role).roleDescription(description).build();
        return authorityRepository.save(authority);
    }
}
