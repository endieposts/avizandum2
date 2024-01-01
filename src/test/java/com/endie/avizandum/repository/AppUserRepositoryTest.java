package com.endie.avizandum.repository;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.endie.avizandum.domain.AppUser;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class AppUserRepositoryTest {

    @Autowired
    AppUserRepository appUserRepository;
    
    @Test
    public void should_find_no_users_if_repository_is_empty() {
        Iterable<AppUser> users = appUserRepository.findAll();

        assertThat(users).isEmpty();
    }
    
    @Test
    public void should_store_a_user() {
    	
        AppUser AppUser = appUserRepository.save(new AppUser("User 1", "password", "default"));
        

        assertThat(AppUser).hasFieldOrPropertyWithValue("userName", "User 1");
        
        appUserRepository.deleteAll();
    }
    
    @Test
    public void should_find_all_users() {
 

    	AppUser AppUser = appUserRepository.save(new AppUser("User 2", "password", "default"));
    	AppUser AppUser2 = appUserRepository.save(new AppUser("User 3", "password", "default"));
    	AppUser AppUser3 = appUserRepository.save(new AppUser("User 4", "password", "default")); 

        Iterable<AppUser> AppUsers = appUserRepository.findAll();

        assertThat(AppUsers).hasSize(3).contains(AppUser, AppUser2, AppUser3);
    }

    @Test
    public void should_find_user_by_id() {

    	AppUser AppUser = appUserRepository.save(new AppUser("User 5", "password", "default"));
    	AppUser AppUser2 = appUserRepository.save(new AppUser("User 6", "password", "default"));

    	AppUser foundAppUser = appUserRepository.findById(AppUser2.getId()).get();

        assertThat(foundAppUser).isEqualTo(AppUser2);
    }
    
    @Test
    public void should_update_user_by_id() {
    	AppUser AppUser = appUserRepository.save(new AppUser("User 7", "password", "default"));
    	AppUser AppUser2 = appUserRepository.save(new AppUser("User 8", "password", "default"));

    	AppUser updatedAppUser = new AppUser("User 1", "password", "default");

    	AppUser foundAppUser = appUserRepository.findById(AppUser2.getId()).get();
    	foundAppUser.setUserName(updatedAppUser.getUserName());
        appUserRepository.save(foundAppUser);

        AppUser checkAppUser = appUserRepository.findById(AppUser2.getId()).get();

        assertThat(checkAppUser.getId()).isEqualTo(AppUser2.getId());
        assertThat(checkAppUser.getUserName()).isEqualTo(updatedAppUser.getUserName());
    }
    
    @Test
    public void should_delete_all_users() {
    	AppUser AppUser = appUserRepository.save(new AppUser("User 9", "password", "default"));
    	AppUser AppUser2 = appUserRepository.save(new AppUser("User 10", "password", "default"));

    	appUserRepository.deleteAll();

        assertThat(appUserRepository.findAll()).isEmpty();
    }
}
