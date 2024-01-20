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

    @Test
    public void should_find_turn_component_by_id() {
        TurnComponent turnComponent = turnComponentRepository.save(new TurnComponent(4L, 1L, 4L, "Test turn component action 4"));
        TurnComponent turnComponent2 = turnComponentRepository.save(new TurnComponent(5L, 3L, 5L, "Test turn component action 5"));

        TurnComponent foundTurnComponent = turnComponentRepository.findById(turnComponent2.getId()).get();

        assertThat(foundTurnComponent).isEqualTo(turnComponent2);
    }

    @Test
    public void should_update_turn_component_by_id() {
        TurnComponent turnComponent = turnComponentRepository.save(new TurnComponent(6L, 1L, 6L, "Test turn component action 6"));
        TurnComponent turnComponent2 = turnComponentRepository.save(new TurnComponent(7L, 3L, 7L, "Test turn component action 7"));

        TurnComponent updatedTurnComponent = new TurnComponent(7L, 3L, 7L, "Updated Test turn component action 7");

        TurnComponent turnComponent3 = turnComponentRepository.save(updatedTurnComponent);
        TurnComponent foundTurnComponent = turnComponentRepository.findById(turnComponent3.getId()).get();

        assertThat(foundTurnComponent.getTurnAction()).isEqualTo(updatedTurnComponent.getTurnAction());
    }

    @Test
    public void should_delete_turn_component_by_id() {
        TurnComponent turnComponent = turnComponentRepository.save(new TurnComponent(8L, 1L, 8L, "Test turn component action 8"));
        TurnComponent turnComponent2 = turnComponentRepository.save(new TurnComponent(9L, 3L, 9L, "Test turn component action 9"));

        turnComponentRepository.deleteById(turnComponent2.getId());

        Iterable<TurnComponent> turnComponents = turnComponentRepository.findAll();

        assertThat(turnComponents).hasSize(1).contains(turnComponent);
    }

    @Test
    public void should_delete_all_turn_components() {
        TurnComponent turnComponent = turnComponentRepository.save(new TurnComponent(10L, 1L, 10L, "Test turn component action 10"));
        TurnComponent turnComponent2 = turnComponentRepository.save(new TurnComponent(11L, 3L, 11L, "Test turn component action 11"));

        turnComponentRepository.deleteAll();

        assertThat(turnComponentRepository.findAll()).isEmpty();
    }
}
