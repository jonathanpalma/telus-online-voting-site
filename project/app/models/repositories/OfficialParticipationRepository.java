package models.repositories;

import models.entities.OfficialParticipation;
import org.springframework.data.repository.CrudRepository;

import javax.inject.Named;
import javax.inject.Singleton;

@Named
@Singleton
public interface OfficialParticipationRepository extends CrudRepository<OfficialParticipation, Long> {
}