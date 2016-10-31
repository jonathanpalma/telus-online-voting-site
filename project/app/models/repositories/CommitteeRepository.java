package models.repositories;

import models.entities.Committee;
import org.springframework.data.repository.CrudRepository;

import javax.inject.Named;
import javax.inject.Singleton;

@Named
@Singleton
public interface CommitteeRepository extends CrudRepository<Committee, Long> {
}