package com.endie.avizandum.repository;

import com.endie.avizandum.domain.TurnComponent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
@ActiveProfiles("test")
public class TurnComponentRepositoryTest {

    @Autowired
    TurnComponentRepository turnComponentRepository;

    @Test
    public void should_find_no_turn_components_if_repository_is_empty() {
        Iterable<TurnComponent> turnComponents = turnComponentRepository.findAll();

        assertThat(turnComponents).isEmpty();
    }

    @Test
    public void should_store_a_turn_component() {
        TurnComponent turnComponent = turnComponentRepository.save(new TurnComponent(1L, 1L, 1L, "Test turn component action"));

        assertThat(turnComponent).hasFieldOrPropertyWithValue("turnAction", "Test turn component action");

        turnComponentRepository.deleteAll();
    }

    @Test
    public void should_find_all_turn_components() {
        TurnComponent turnComponent = turnComponentRepository.save(new TurnComponent(1L, 1L, 1L, "Test turn component action"));
        TurnComponent turnComponent2 = turnComponentRepository.save(new TurnComponent(2L, 1L, 2L, "Test turn component action 2"));
        TurnComponent turnComponent3 = turnComponentRepository.save(new TurnComponent(3L, 2L, 3L, "Test turn component action 3"));

        Iterable<TurnComponent> turnComponents = turnComponentRepository.findAll();

        assertThat(turnComponents).hasSize(3).contains(turnComponent, turnComponent2, turnComponent3);
    }
}
