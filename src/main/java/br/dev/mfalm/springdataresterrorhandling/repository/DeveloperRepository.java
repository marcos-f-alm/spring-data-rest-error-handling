package br.dev.mfalm.springdataresterrorhandling.repository;

import br.dev.mfalm.springdataresterrorhandling.domain.Developer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {
    @RestResource(path = "/findBySkill")
    Page<Developer> findBySkills_ShortNameEquals(@Param("name") String shortName, Pageable pageable);
}