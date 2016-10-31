package models.repositories;

import models.entities.Role;
import org.springframework.data.repository.CrudRepository;

import javax.inject.Named;
import javax.inject.Singleton;

@Named
@Singleton
public interface RoleRepository extends CrudRepository<Role, Long> {
}