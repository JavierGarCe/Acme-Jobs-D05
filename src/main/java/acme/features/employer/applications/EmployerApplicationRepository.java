
package acme.features.employer.applications;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.applications.Application;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerApplicationRepository extends AbstractRepository {

	@Query("select aj from Application aj where aj.id = ?1")
	Application findOneById(int id);

	@Query("select j.id from Application a join a.job j where a.id= ?1")
	int findId(int id);

	@Query("select a from Application a where a.job.employer.id = ?1 order by a.status")
	Collection<Application> findManyByEmployerIdGroupByStatus(int EmployerId);

	@Query("select a from Application a where a.job.employer.id = ?1 order by a.reference")
	Collection<Application> findManyByEmployerIdGroupByReference(int EmployerId);

	@Query("select a from Application a where a.job.employer.id = ?1 order by a.moment")
	Collection<Application> findManyByEmployerIdGroupByMoment(int EmployerId);

	@Query("select a from Application a where a.job.employer.id = ?1")
	Collection<Application> findManyByEmployerId(int EmployerId);
}
