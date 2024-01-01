package com.endie.avizandum.repository;

import com.endie.avizandum.domain.District;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@ActiveProfiles("test")
public class DistrictRepositoryTest {

    @Autowired
    DistrictRepository districtRepository;
    
    @Test
    public void should_find_no_districts_if_repository_is_empty() {
        Iterable<District> districts = districtRepository.findAll();

        assertThat(districts).isEmpty();
    }
    
    @Test
    public void should_store_a_district() {
        District district = districtRepository.save(new District(1L, 1L, "Test district name"));

        assertThat(district).hasFieldOrPropertyWithValue("name", "Test district name");
        assertThat(district).hasFieldOrPropertyWithValue("terrainId", 1L);
        
        districtRepository.deleteAll();
    }
    
    @Test
    public void should_find_all_districts() {
        District district1 = districtRepository.save(new District(1L, "Test district name"));
        District district2 = districtRepository.save(new District(1L, "Test district name 2"));
        District district3 = districtRepository.save(new District(1L, "Test district name 3"));

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
    
    @Test
    public void should_update_district_by_id() {
    	District district1 = new District(1L, "F Test district name 6");
    	districtRepository.save(district1);
    	
    	District district2 = new District(2L, "G Test district name 7");
    	districtRepository.save(district2);

        District updatedDistrict = new District(3L, "H updated District 7 name");

        District district = districtRepository.findById(district2.getId()).get();
        district.setName(updatedDistrict.getName());
        district.setTerrainId(updatedDistrict.getTerrainId());
        districtRepository.save(district);

        District checkDistrict = districtRepository.findById(district2.getId()).get();

        assertThat(checkDistrict.getId()).isEqualTo(district2.getId());
        assertThat(checkDistrict.getName()).isEqualTo(updatedDistrict.getName());
        assertThat(checkDistrict.getTerrainId()).isEqualTo(updatedDistrict.getTerrainId());
    }
    
    @Test
    public void should_delete_all_districts() {
    	District district1 = new District(1L, "Test district name 8");
    	districtRepository.save(district1);
    	
    	District district2 = new District(2L, "Test district name 9");
    	districtRepository.save(district2);

        districtRepository.deleteAll();

        assertThat(districtRepository.findAll()).isEmpty();
    }
}
