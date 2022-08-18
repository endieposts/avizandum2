package com.endie.avizandum.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.endie.avizandum.domain.AppUser;

public interface AppUserRepository extends JpaRepository <AppUser, Long> {
	//Optional<User> findByUsername(String username);
}
