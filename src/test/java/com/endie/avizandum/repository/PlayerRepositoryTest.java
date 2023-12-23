package com.endie.avizandum.repository;

import com.endie.avizandum.domain.Domain;
import com.endie.avizandum.domain.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class PlayerRepositoryTest {
    @Autowired
    PlayerRepository playerRepository;

    @Test
    public void should_find_no_players_if_repository_is_empty() {
        Iterable<Player> players = playerRepository.findAll();

        assertThat(players).isEmpty();
    }

}
