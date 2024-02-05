package com.endie.avizandum.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import com.endie.avizandum.domain.Terrain;

@DataJpaTest
@ActiveProfiles("test")
public class TerrainRepositoryTest {

    @Autowired
    TerrainRepository terrainRepository;
    
    @Test
    public void should_find_no_terrains_if_repository_is_empty() {
        Iterable<Terrain> terrains = terrainRepository.findAll();

        assertThat(terrains).isEmpty();
    }
    
    @Test
    public void should_store_a_terrain() {
        Terrain terrain = terrainRepository.save(new Terrain("Test terrain name"));

        assertThat(terrain).hasFieldOrPropertyWithValue("name", "Test terrain name");
        
        terrainRepository.deleteAll();
    }
    
    @Test
    public void should_find_all_terrains() {
    	Terrain terrain = terrainRepository.save(new Terrain("Test terrain name"));
    	Terrain terrain2 = terrainRepository.save(new Terrain("Test terrain name 2"));
    	Terrain terrain3 = terrainRepository.save(new Terrain("Test terrain name 3")); 

        Iterable<Terrain> terrains = terrainRepository.findAll();

        assertThat(terrains).hasSize(3).contains(terrain, terrain2, terrain3);
    }

    @Test
    public void should_find_terrain_by_id() {
    	Terrain terrain = terrainRepository.save(new Terrain("Test terrain name 4"));
    	Terrain terrain2 = terrainRepository.save(new Terrain("Test terrain name 5"));

    	Terrain foundTerrain = terrainRepository.findById(terrain2.getId()).get();

        assertThat(foundTerrain).isEqualTo(terrain2);
    }
    
    @Test
    public void should_update_terrain_by_id() {
    	Terrain terrain = terrainRepository.save(new Terrain("Test terrain name 6"));
    	Terrain terrain2 = terrainRepository.save(new Terrain("Test terrain name 7"));

    	Terrain updatedTerrain = new Terrain("H updated terrain 7 name");

    	Terrain foundTerrain = terrainRepository.findById(terrain2.getId()).get();
    	foundTerrain.setName(updatedTerrain.getName());
        terrainRepository.save(foundTerrain);

        Terrain checkTerrain = terrainRepository.findById(terrain2.getId()).get();

        assertThat(checkTerrain.getId()).isEqualTo(terrain2.getId());
        assertThat(checkTerrain.getName()).isEqualTo(updatedTerrain.getName());
    }

    @Test
    public void should_delete_terrain_by_id() {
    	Terrain terrain = terrainRepository.save(new Terrain("Test terrain name 8"));
    	Terrain terrain2 = terrainRepository.save(new Terrain("Test terrain name 9"));

    	terrainRepository.deleteById(terrain2.getId());

        assertThat(terrainRepository.findAll()).hasSize(1).contains(terrain);
    }

    @Test
    public void should_delete_all_terrains() {
    	Terrain terrain = terrainRepository.save(new Terrain("Test terrain name 8"));
    	Terrain terrain2 = terrainRepository.save(new Terrain("Test terrain name 9"));

    	terrainRepository.deleteAll();

        assertThat(terrainRepository.findAll()).isEmpty();
    }
}
