package com.endie.avizandum.repository;

import com.endie.avizandum.domain.TurnComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnComponentRepository extends JpaRepository<TurnComponent, Long>{
}
