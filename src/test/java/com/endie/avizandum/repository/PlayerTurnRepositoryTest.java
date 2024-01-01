package com.endie.avizandum.repository;

import com.endie.avizandum.domain.Player;
import com.endie.avizandum.domain.PlayerTurn;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class PlayerTurnRepositoryTest {
    @Autowired
    PlayerTurnRepository playerTurnRepository;

    @Test
    public void should_find_no_player_turns_if_repository_is_empty() {
        Iterable<PlayerTurn> playerTurns = playerTurnRepository.findAll();

        assertThat(playerTurns).isEmpty();
    }

    @Test
    public void should_store_a_player_turn() {
        PlayerTurn playerTurn = playerTurnRepository.save(new PlayerTurn( 1L, 1L));

        assertThat(playerTurn).hasFieldOrPropertyWithValue("playerId", 1L);

        playerTurnRepository.deleteAll();
    }
}
