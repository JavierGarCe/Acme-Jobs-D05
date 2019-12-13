
package acme.features.authenticated.userThread;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.threads.Thread;
import acme.framework.entities.Authenticated;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedUsersThreadRepository extends AbstractRepository {

	@Query("select t from Thread t where t.id = ?1")
	Thread findOneById(int id);

	@Query("select a from Authenticated a where a not in (select t from Thread t where t.id=?1)")
	Collection<Authenticated> findAuthenticatedNoThread(int id);

}
