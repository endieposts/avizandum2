package com.endie.avizandum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.endie.avizandum.domain.Terrain;
import org.springframework.stereotype.Repository;

@Repository
public interface TerrainRepository extends JpaRepository<Terrain, Long>{

}
