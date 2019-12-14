
package acme.features.authenticated.authenticated;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedAuthenticatedListService implements AbstractListService<Authenticated, Authenticated> {

	@Autowired
	private AuthenticatedAuthenticatedRepository repository;


	@Override
	public boolean authorise(final Request<Authenticated> request) {
		assert request != null;
		// TODO hay que ver que exista un hilo con la id dada y que yo sea su propietario?
		return true;
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
		int threadId = request.getModel().getInteger("threadId");
		result = this.repository.findUserThreadNotInThread(threadId);

		return result;

	}
}
