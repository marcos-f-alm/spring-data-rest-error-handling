package br.dev.mfalm.springdataresterrorhandling.repository;

import br.dev.mfalm.springdataresterrorhandling.domain.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {
    @RestResource(path = "/findBySkill")
    List<Developer> findBySkills_ShortNameEquals(String shortName);
}