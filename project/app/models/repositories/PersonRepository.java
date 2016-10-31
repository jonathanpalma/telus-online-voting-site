package models.repositories;

import models.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Provides CRUD functionality for accessing people. Spring Data auto-magically takes care of many standard
 * operations here.
 */
@Named
@Singleton
public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query("SELECT p.pass FROM Person p WHERE p.iddocument = :username")
    String findPassByDocument(@Param("iddocument") String iddocument);

    @Query("SELECT p FROM Person p WHERE p.iddocument = :iddocument")
    Person findByDocument(@Param("iddocument") String iddocument);

}