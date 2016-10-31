package models.repositories;

import models.entities.Candidate;
import org.springframework.data.repository.CrudRepository;

import javax.inject.Named;
import javax.inject.Singleton;

@Named
@Singleton
public interface CandidateRepository extends CrudRepository<Candidate, Long> {
}