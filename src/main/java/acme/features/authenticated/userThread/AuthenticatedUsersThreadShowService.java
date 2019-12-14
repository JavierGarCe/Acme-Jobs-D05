
package acme.features.authenticated.userThread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.threads.UserThread;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedUsersThreadShowService implements AbstractShowService<Authenticated, UserThread> {

	@Autowired
	private AuthenticatedUsersThreadRepository repository;


	@Override
	public boolean authorise(final Request<UserThread> request) {
		assert request != null;
		// TODO
		return true;
	}

	@Override
	public void unbind(final Request<UserThread> request, final UserThread entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "authenticated.userAccount.username");
	}

	@Override
	public UserThread findOne(final Request<UserThread> request) {
		assert request != null;

		UserThread result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneUserThreadById(id);

		return result;
	}
}
