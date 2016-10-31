package models.repositories;

import models.entities.Election;
import org.springframework.data.repository.CrudRepository;

import javax.inject.Named;
import javax.inject.Singleton;

@Named
@Singleton
public interface ElectionRepository extends CrudRepository<Election, Long> {
}