package com.endie.avizandum.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.endie.avizandum.domain.Domain;

@DataJpaTest
@ActiveProfiles("test")
public class DomainRepositoryTest {
    @Autowired
    DomainRepository domainRepository;
    
    @Test
    public void should_find_no_domains_if_repository_is_empty() {
        Iterable<Domain> domains = domainRepository.findAll();

        assertThat(domains).isEmpty();
    }
    
    @Test
    public void should_store_a_domain() {
        Domain domain = domainRepository.save(new Domain("Test domain name", 1L, null));

        assertThat(domain).hasFieldOrPropertyWithValue("name", "Test domain name");
        
        domainRepository.deleteAll();
    }
    
    @Test
    public void should_find_all_domains() {
    	Domain domain = domainRepository.save(new Domain("Test domain name", 1L, null));
    	Domain domain2 = domainRepository.save(new Domain("Test domain name 2", 1L, null));
    	Domain domain3 = domainRepository.save(new Domain("Test domain name 3", 1L, null));

        Iterable<Domain> domains = domainRepository.findAll();

        assertThat(domains).hasSize(3).contains(domain, domain2, domain3);
    }

    @Test
    public void should_find_domain_by_id() {
    	Domain domain = domainRepository.save(new Domain("Test domain name 4", 1L, null));
    	Domain domain2 = domainRepository.save(new Domain("Test domain name 5", 1L, null));

    	Domain founddomain = domainRepository.findById(domain2.getId()).get();

        assertThat(founddomain).isEqualTo(domain2);
    }
    
    @Test
    public void should_update_domain_by_id() {
    	Domain domain = domainRepository.save(new Domain("Test domain name 6", 1L, null));
    	Domain domain2 = domainRepository.save(new Domain("Test domain name 7", 1L, null));

    	Domain updatedDomain = new Domain("Updated Test domain name 7", 1L, null);

    	Domain foundDomain = domainRepository.findById(domain2.getId()).get();
    	foundDomain.setName(updatedDomain.getName());
        domainRepository.save(foundDomain);

        Domain checkdomain = domainRepository.findById(domain2.getId()).get();

        assertThat(checkdomain.getId()).isEqualTo(domain2.getId());
        assertThat(checkdomain.getName()).isEqualTo(updatedDomain.getName());
    }

    @Test
    public void should_delete_domain_by_id() {
    	Domain domain = domainRepository.save(new Domain("Test domain name 8", 1L, null));
    	Domain domain2 = domainRepository.save(new Domain("Test domain name 9", 1L, null));

    	domainRepository.deleteById(domain2.getId());

        assertThat(domainRepository.findById(domain2.getId())).isEmpty();
    }
    @Test
    public void should_delete_all_domains() {
    	Domain domain = domainRepository.save(new Domain("Test domain name 8", 1L, null));
    	Domain domain2 = domainRepository.save(new Domain("Test domain name 10", 1L, null));

    	domainRepository.deleteAll();

        assertThat(domainRepository.findAll()).isEmpty();
    }
}
