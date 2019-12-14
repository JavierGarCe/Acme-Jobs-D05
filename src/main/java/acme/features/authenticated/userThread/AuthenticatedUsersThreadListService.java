
package acme.features.authenticated.userThread;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.threads.UserThread;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedUsersThreadListService implements AbstractListService<Authenticated, UserThread> {

	@Autowired
	private AuthenticatedUsersThreadRepository repository;


	@Override
	public boolean authorise(final Request<UserThread> request) {
		assert request != null;

		/*
		 * int idThread = request.getModel().getInteger("id");
		 * Thread thread = this.repository.findOneById(idThread);
		 * List<Authenticated> authenticateds = (List<Authenticated>) thread.getAuthenticateds();
		 * Principal principal = request.getPrincipal();
		 * boolean result = authenticateds.stream().filter(x -> x.getUserAccount().getId() == principal.getAccountId()).count() > 0;
		 * return result;
		 */

		return true;
	}

	@Override
	public void unbind(final Request<UserThread> request, final UserThread entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "authenticated.userAccount.username"); //DUDA

	}

	@Override
	public Collection<UserThread> findMany(final Request<UserThread> request) {
		assert request != null;

		Collection<UserThread> result;
		int threadId = request.getModel().getInteger("id");

		result = this.repository.findUserThreadsInThread(threadId);

		return result;

	}

}
