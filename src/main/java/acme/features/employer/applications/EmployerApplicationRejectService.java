
package acme.features.employer.applications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.datatypes.ApplicationStatus;
import acme.entities.applications.Application;
import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractUpdateService;

@Service
public class EmployerApplicationRejectService implements AbstractUpdateService<Employer, Application> {

	@Autowired
	private EmployerApplicationRepository repository;


	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;
		boolean result;
		int applicationId;
		Application application;
		Job job;
		Employer employer;
		Principal principal;

		applicationId = request.getModel().getInteger("id");
		application = this.repository.findOneById(applicationId);
		job = application.getJob();
		employer = job.getEmployer();
		principal = request.getPrincipal();
		result = employer.getUserAccount().getId() == principal.getAccountId();

		return result && application.getStatus() == ApplicationStatus.PENDING;
	}

	@Override
	public void bind(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "status", "justification");

	}

	@Override
	public Application findOne(final Request<Application> request) {
		assert request != null;

		Application result;
		int id;

		id = request.getModel().getInteger("id");

		result = this.repository.findOneById(id);

		return result;
	}

	@Override
	public void validate(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		if (!errors.hasErrors("justification")) {
			Boolean isFilled = !entity.getJustification().equals("");
			errors.state(request, isFilled, "justification", "employer.justification.error.notblank");
		}

	}

	@Override
	public void update(final Request<Application> request, final Application entity) {
		assert request != null;
		assert entity != null;

		entity.setStatus(ApplicationStatus.REJECTED);
		this.repository.save(entity);

	}

}