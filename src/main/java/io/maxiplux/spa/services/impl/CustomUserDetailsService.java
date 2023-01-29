package io.maxiplux.spa.services.impl;


import io.maxiplux.spa.models.Role;
import io.maxiplux.spa.models.User;
import io.maxiplux.spa.repositories.RoleRepository;
import io.maxiplux.spa.repositories.UserRepository;
import io.maxiplux.spa.services.UserServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("CustomUserDetailsService")
@Slf4j
public class CustomUserDetailsService implements UserDetailsService, UserServices {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
        User usuario = userRepository.findByUsername(username);
        
        if(usuario == null) {
        	log.error("Error en el Login: no existe el usuario '" + username + "' en el sistema!");
        	throw new UsernameNotFoundException("Username: " + username + " no existe en el sistema!");
        }
        
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        
        for(Role role: usuario.getRoles()) {
        	log.info("Role: ".concat(role.getAuthority()));
        	authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }
        
        if(authorities.isEmpty()) {
        	log.error("Error en el Login: Usuario '" + username + "' no tiene roles asignados!");
        	throw new UsernameNotFoundException("Error en el Login: usuario '" + username + "' no tiene roles asignados!");
        }
		return usuario;
	}


	@Override
	public void saveUser(User user) {
		this.userRepository.save(user);
	}

	@Override
	public User findByUsername(String username, String password) {
		User user=	this.userRepository.findByUsername(username);
		if(user!=null && user.getPassword().equals(this.passwordEncoder.encode(password))){
			return user;
		}

		throw new UsernameNotFoundException("Error en el Login: usuario '" + username + "' no tiene roles asignados!");
	}

	@Override
	public Role saveRole(Role roleAdmin) {
		return this.roleRepository.save(roleAdmin);
	}
}
