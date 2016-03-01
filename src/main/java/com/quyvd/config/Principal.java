package com.quyvd.config;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class Principal {

	public String getPrincipal(){
        String userName = "";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
