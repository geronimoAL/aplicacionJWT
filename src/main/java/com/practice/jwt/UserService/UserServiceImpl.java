package com.practice.jwt.UserService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.jwt.UserRepository.RoleRepository;
import com.practice.jwt.UserRepository.UserRepository;
import com.practice.jwt.domain.Role;
import com.practice.jwt.domain.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private  RoleRepository roleRepository;
	
	@Autowired
	private  UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		log.info("Guardando nuevo usuario {} en la base de datos", user.getUsername());
		return userRepository.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		log.info("Guardando nuevo rol {} en la base de datos", role.getName());
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String correo, String roleName) {
		log.info("Asignando rol {} a usuario {} ", correo,roleName);
		Optional<Role> role= roleRepository.findByname(roleName);
                Role rol=role.get();
		Optional<User>user=userRepository.findByEmail(correo);
        if(user.isPresent()) {
        	User userPresent=user.get();
        	userPresent.getRoles().add(rol);
        	
        }
		
    
	}

	@Override
	public User getUser(String username) {
		log.info("Buscando usuario {} ",username);
		Optional<User> user=userRepository.findByEmail(username);
//		ver esta parte
//		if(user.isPresent()) {
			User userPresent=user.get();
//		}
		return userPresent;
	}

	@Override
	public List<User> getUsers() {
		log.debug("Buscando usuarios");
		return userRepository.findAll();
	}

}
