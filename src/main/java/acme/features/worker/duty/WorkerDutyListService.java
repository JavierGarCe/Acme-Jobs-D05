
package acme.features.worker.duty;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Duty;
import acme.entities.roles.Worker;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;

@Service
public class WorkerDutyListService implements AbstractListService<Worker, Duty> {

	@Autowired
	private WorkerDutyRepository repository;


	@Override
	public boolean authorise(final Request<Duty> request) {
		assert request != null;
		int jobId;
		Principal principal;

		jobId = request.getModel().getInteger("id");
		principal = request.getPrincipal();

		return this.repository.findNumberApplicationsByJobId(jobId, principal.getActiveRoleId()) > 0;
	}

	@Override
	public void unbind(final Request<Duty> request, final Duty entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "description");

	}

	@Override
	public Collection<Duty> findMany(final Request<Duty> request) {
		assert request != null;

		Collection<Duty> result;
		int id;

		id = request.getModel().getInteger("id");

		result = this.repository.findDutiesByJobId(id);

		return result;
	}

}
