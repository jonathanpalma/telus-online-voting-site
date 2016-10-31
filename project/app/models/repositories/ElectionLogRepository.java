package models.repositories;

import org.springframework.data.repository.CrudRepository;

import javax.inject.Named;
import javax.inject.Singleton;

@Named
@Singleton
public interface ElectionLogRepository extends CrudRepository<ElectionLogRepository, Long> {
}