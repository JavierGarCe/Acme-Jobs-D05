
package acme.features.employer.applications;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.applications.Application;
import acme.entities.roles.Employer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class EmployerApplicationListService implements AbstractListService<Employer, Application> {

	@Autowired
	private EmployerApplicationRepository repository;


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

		request.unbind(entity, model, "moment", "status", "statement", "reference");
	}

	@Override
	public Collection<Application> findMany(final Request<Application> request) {
		assert request != null;
		String group;
		Collection<Application> result;
		int id = request.getPrincipal().getActiveRoleId();
		group = request.getModel().getString("group");

		if (group == "creation") {
			result = this.repository.findManyByEmployerIdGroupByMoment(id);
		} else if (group == "reference") {
			result = this.repository.findManyByEmployerIdGroupByReference(id);
		} else if (group == "status") {
			result = this.repository.findManyByEmployerIdGroupByStatus(id);
		} else {
			result = this.repository.findManyByEmployerId(id);
		}

		return result;
	}

}
