package com.endie.avizandum.repository;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.endie.avizandum.domain.AppUser;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTest {

    @Autowired
    AppUserRepository appUserRepository;
    
    @Test
    public void should_find_no_users_if_repository_is_empty() {
        Iterable<AppUser> users = appUserRepository.findAll();

        assertThat(users).isEmpty();
    }
}
