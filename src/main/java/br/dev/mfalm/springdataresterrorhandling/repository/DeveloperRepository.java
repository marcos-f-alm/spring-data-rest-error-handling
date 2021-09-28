package br.dev.mfalm.springdataresterrorhandling.repository;

import br.dev.mfalm.springdataresterrorhandling.domain.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {
}