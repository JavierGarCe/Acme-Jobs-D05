
package acme.features.worker.job;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface WorkerJobRepository extends AbstractRepository {

	@Query("select j from Job j where j.id = ?1")
	Job findJobById(int id);

	@Query("select count(a) from Application a where a.job.id = ?1 and a.worker.id=?2")
	int findNumberApplicationsByJobId(int id1, int id2);
}
