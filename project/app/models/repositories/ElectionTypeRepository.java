package models.repositories;

import models.entities.ElectionType;
import org.springframework.data.repository.CrudRepository;

import javax.inject.Named;
import javax.inject.Singleton;

@Named
@Singleton
public interface ElectionTypeRepository extends CrudRepository<ElectionType, Long> {
}