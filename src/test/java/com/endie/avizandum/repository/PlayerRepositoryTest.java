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

    @Test
    public void should_store_a_player() {

        Player player = playerRepository.save(new Player("Test player name", 1L, 1L));


        assertThat(player).hasFieldOrPropertyWithValue("name", "Test player name");

        playerRepository.deleteAll();
    }

    @Test
    public void should_find_all_players() {


        Player player = playerRepository.save(new Player("Test player name", 1L, 1L));
        Player player2 = playerRepository.save(new Player("Test player name 2", 1L, 1L));
        Player player3 = playerRepository.save(new Player("Test player name 3", 1L, 1L));

        Iterable<Player> players = playerRepository.findAll();

        assertThat(players).hasSize(3).contains(player, player2, player3);
    }

    @Test
    public void should_find_player_by_id() {

        Player player = playerRepository.save(new Player("Test player name 4", 1L, 1L));
        Player player2 = playerRepository.save(new Player("Test player name 5", 1L, 1L));

        Player foundPlayer = playerRepository.findById(player2.getId()).get();

        assertThat(foundPlayer).isEqualTo(player2);
    }

    @Test
    public void should_update_player_by_id() {
        Player player = playerRepository.save(new Player("Test player name 6", 1L, 1L));
        Player player2 = playerRepository.save(new Player("Test player name 7", 1L, 1L));

        Player updatedPlayer = new Player("Updated Test player name 7", 1L, 1L);

        Player foundPlayer = playerRepository.findById(player2.getId()).get();
        foundPlayer.setName(updatedPlayer.getName());
        playerRepository.save(foundPlayer);

        Player checkplayer = playerRepository.findById(player2.getId()).get();

        assertThat(checkplayer.getId()).isEqualTo(player2.getId());
        assertThat(checkplayer.getName()).isEqualTo(updatedPlayer.getName());
    }
}
