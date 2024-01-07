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

    @Test
    public void should_find_all_player_turns() {
        PlayerTurn playerTurn = playerTurnRepository.save(new PlayerTurn( 1L, 1L));
        PlayerTurn playerTurn2 = playerTurnRepository.save(new PlayerTurn( 2L, 1L));
        PlayerTurn playerTurn3 = playerTurnRepository.save(new PlayerTurn( 3L, 1L));

        Iterable<PlayerTurn> playerTurns = playerTurnRepository.findAll();

        assertThat(playerTurns).hasSize(3).contains(playerTurn, playerTurn2, playerTurn3);
    }

    @Test
    public void should_find_player_turn_by_id() {
        PlayerTurn playerTurn = playerTurnRepository.save(new PlayerTurn( 2L, 2L));
        PlayerTurn playerTurn2 = playerTurnRepository.save(new PlayerTurn( 2L, 3L));

        PlayerTurn foundPlayerTurn = playerTurnRepository.findById(playerTurn2.getId()).get();

        assertThat(foundPlayerTurn).isEqualTo(playerTurn2);
    }

    @Test
    public void should_update_player_turn_by_id() {
        PlayerTurn playerTurn = playerTurnRepository.save(new PlayerTurn( 3L, 4L));
        PlayerTurn playerTurn2 = playerTurnRepository.save(new PlayerTurn( 3L, 5L));

        PlayerTurn updatedPlayerTurn = new PlayerTurn( 3L, 6L);

        PlayerTurn foundPlayer = playerTurnRepository.findById(playerTurn2.getId()).get();
        foundPlayer.setTurnNumber(updatedPlayerTurn.getTurnNumber());
        playerTurnRepository.save(foundPlayer);

        PlayerTurn checkPlayer = playerTurnRepository.findById(playerTurn2.getId()).get();

        assertThat(checkPlayer.getId()).isEqualTo(playerTurn2.getId());
        assertThat(checkPlayer.getTurnNumber()).isEqualTo(updatedPlayerTurn.getTurnNumber());
    }

    @Test
    public void should_delete_all_player_turns() {
        playerTurnRepository.save(new PlayerTurn( 4L, 7L));
        playerTurnRepository.save(new PlayerTurn( 4L, 8L));

        playerTurnRepository.deleteAll();

        assertThat(playerTurnRepository.findAll()).isEmpty();
    }
}
