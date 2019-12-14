
package acme.features.authenticated.authenticated;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.entities.Authenticated;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedAuthenticatedRepository extends AbstractRepository {

	@Query("select a from Authenticated a where a not in (select ut.authenticated from UserThread ut where ut.thread.id = ?1)")
	Collection<Authenticated> findUserThreadNotInThread(int threadId);

	@Query("select a from Authenticated a where a.id = ?1")
	Authenticated findOneById(int id);
}
