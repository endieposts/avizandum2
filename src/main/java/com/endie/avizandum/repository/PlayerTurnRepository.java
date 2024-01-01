package com.endie.avizandum.repository;

import com.endie.avizandum.domain.PlayerTurn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerTurnRepository extends JpaRepository<PlayerTurn, Long> {

}
