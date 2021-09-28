package br.dev.mfalm.springdataresterrorhandling.repository;

import br.dev.mfalm.springdataresterrorhandling.domain.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, String> {
}