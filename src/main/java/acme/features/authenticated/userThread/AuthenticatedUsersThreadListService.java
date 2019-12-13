
package acme.features.authenticated.userThread;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.threads.Thread;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedUsersThreadListService implements AbstractListService<Authenticated, Authenticated> {

	@Autowired
	private AuthenticatedUsersThreadRepository repository;


	@Override
	public boolean authorise(final Request<Authenticated> request) {
		int idThread = request.getModel().getInteger("id");
		Thread thread = this.repository.findOneById(idThread);
		List<Authenticated> authenticateds = (List<Authenticated>) thread.getAuthenticateds();
		Principal principal = request.getPrincipal();
		boolean result = authenticateds.stream().filter(x -> x.getUserAccount().getId() == principal.getAccountId()).count() > 0;
		return result;
	}

	@Override
	public void unbind(final Request<Authenticated> request, final Authenticated entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "userAccount.username"); //DUDA

	}

	@Override
	public Collection<Authenticated> findMany(final Request<Authenticated> request) {
		assert request != null;

		Collection<Authenticated> result;
		Thread thread = this.repository.findOneById(request.getModel().getInteger("id"));

		thread.getAuthenticateds().size();
		result = thread.getAuthenticateds();
		return result;

	}

}
