package com.endie.avizandum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.endie.avizandum.domain.District;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long>{

}
