
package acme.features.authenticated.userThread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.threads.Thread;
import acme.entities.threads.UserThread;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractCreateService;

@Service
public class AuthenticatedUserThreadCreateService implements AbstractCreateService<Authenticated, UserThread> {

	@Autowired
	private AuthenticatedUsersThreadRepository repository;


	@Override
	public boolean authorise(final Request<UserThread> request) {
		assert request != null;
		// TODO Solo podra meter un usuario en un hilo si es su hilo
		return true;
	}

	@Override
	public void bind(final Request<UserThread> request, final UserThread entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<UserThread> request, final UserThread entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "authenticated.userAccount.username");
	}

	@Override
	public UserThread instantiate(final Request<UserThread> request) {
		assert request != null;

		UserThread result;
		int authenticatedId;
		int threadId;

		authenticatedId = request.getModel().getInteger("id");
		threadId = request.getModel().getInteger("threadId");

		Authenticated authenticated = this.repository.findOneAuthenticatedById(authenticatedId);
		Thread thread = this.repository.findOneById(threadId);

		result = new UserThread();
		result.setAuthenticated(authenticated);
		result.setThread(thread);

		return result;
	}

	@Override
	public void validate(final Request<UserThread> request, final UserThread entity, final Errors errors) {
		assert request != null;
		//ALGO MAS?

	}

	@Override
	public void create(final Request<UserThread> request, final UserThread entity) {
		assert request != null;

		this.repository.save(entity);
	}
}
