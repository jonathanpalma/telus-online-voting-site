package models.repositories;

import models.entities.Country;
import org.springframework.data.repository.CrudRepository;

import javax.inject.Named;
import javax.inject.Singleton;

@Named
@Singleton
public interface CountryRepository extends CrudRepository<Country, Integer> {
}