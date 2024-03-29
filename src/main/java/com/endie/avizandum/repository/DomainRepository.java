package com.endie.avizandum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.endie.avizandum.domain.Domain;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainRepository extends JpaRepository<Domain, Long>{


}
