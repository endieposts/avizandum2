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
    	
    	//Terrain terrain = new Terrain(1L, "Bog");
    	//District district = new District(1L, 1L, "Test district name", 1L);
    	//List<District> districts = new ArrayList<>();
    	//districts.add(district);
    	//Domain domain = new Domain(1L, "Test Domain", 1L, districts);
    	//district.setDomain(domain);
    	
        District district = districtRepository.save(new District(1L, 1L, "Test district name"));
        

        assertThat(district).hasFieldOrPropertyWithValue("name", "Test district name");
        assertThat(district).hasFieldOrPropertyWithValue("terrainId", 1L);
        
        districtRepository.deleteAll();
    }
    
    @Test
    public void should_find_all_districts() {
 

        District district1 = districtRepository.save(new District(2L, 1L, "Test district name"));
        District district2 = districtRepository.save(new District(3L, 1L, "Test district name 2"));
        District district3 = districtRepository.save(new District(4L, 1L, "Test district name 3"));

        Iterable<District> districts = districtRepository.findAll();

        assertThat(districts).hasSize(3).contains(district1, district2, district3);
    }
    
    @Test
    public void should_find_district_by_id() {

    	District district1 = new District(1L, "Test district name 4");
    	districtRepository.save(district1);
    	
    	District district2 = new District(2L, "Test district name 5");
    	districtRepository.save(district2);

        District foundDistrict = districtRepository.findById(district2.getId()).get();

        assertThat(foundDistrict).isEqualTo(district2);

    }
}
