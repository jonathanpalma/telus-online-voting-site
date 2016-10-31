package models.repositories;

import models.entities.State;
import org.springframework.data.repository.CrudRepository;

import javax.inject.Named;
import javax.inject.Singleton;

@Named
@Singleton
public interface StateRepository extends CrudRepository<State, Long> {
}