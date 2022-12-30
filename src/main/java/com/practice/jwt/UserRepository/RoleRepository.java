package com.practice.jwt.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.jwt.domain.Role;
import java.util.Optional;


public interface RoleRepository extends JpaRepository<Role,Long>{
	Optional<Role> findByname(String name);
}
