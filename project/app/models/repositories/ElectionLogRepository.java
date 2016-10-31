package models.repositories;

import models.entities.ElectionLog;
import org.springframework.data.repository.CrudRepository;

import javax.inject.Named;
import javax.inject.Singleton;

@Named
@Singleton
public interface ElectionLogRepository extends CrudRepository<ElectionLog, Long> {
}