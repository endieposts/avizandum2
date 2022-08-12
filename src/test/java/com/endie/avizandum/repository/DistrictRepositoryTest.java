package com.endie.avizandum.repository;

import com.endie.avizandum.domain.District;
import com.endie.avizandum.domain.Domain;
import com.endie.avizandum.domain.Terrain;
import com.endie.avizandum.repository.DistrictRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@ActiveProfiles("test")
public class DistrictRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    DistrictRepository districtRepository;
    
    @Test
    public void should_find_no_districts_if_repository_is_empty() {
        Iterable<District> districts = districtRepository.findAll();

        assertThat(districts).isEmpty();
    }
    
    @Test
    public void should_store_a_district() {
    	
    	Terrain terrain = new Terrain(1L, "Bog");
    	District district = new District(1L, terrain, "Test name", null);
    	List<District> districts = new ArrayList<>();
    	districts.add(district);
    	Domain domain = new Domain(1L, "Test Domain", 1L, districts);
    	district.setDomain(domain);
    	
        district = districtRepository.save(district);
        

        assertThat(district).hasFieldOrPropertyWithValue("name", "Test name");
        assertThat(district.getTerrain().getId()).isEqualTo(1L);
    }
}
