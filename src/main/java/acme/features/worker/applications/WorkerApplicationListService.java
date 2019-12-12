
package acme.features.worker.applications;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.applications.Application;
import acme.entities.roles.Worker;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class WorkerApplicationListService implements AbstractListService<Worker, Application> {

	@Autowired
	private WorkerApplicationRepository repository;


	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "moment", "status", "statement");
	}

	@Override
	public Collection<Application> findMany(final Request<Application> request) {
		assert request != null;
		String group;
		Collection<Application> result;
		int id = request.getPrincipal().getActiveRoleId();
		group = request.getModel().getString("group");

		if (group == "creation") {
			result = this.repository.findManyByWorkerIdGroupByMoment(id);
		} else if (group == "reference") {
			result = this.repository.findManyByWorkerIdGroupByReference(id);
		} else if (group == "status") {
			result = this.repository.findManyByWorkerIdGroupByStatus(id);
		} else {
			result = this.repository.findManyByWorkerId(id);
		}

		return result;
	}

}
