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
}
