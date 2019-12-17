
package acme.features.employer.applications;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.applications.Application;
import acme.entities.roles.Employer;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/employer/application/")
public class EmployerApplicationController extends AbstractController<Employer, Application> {

	@Autowired
	private EmployerApplicationListService				listMineService;

	@Autowired
	private EmployerApplicationShowService				showService;

	@Autowired
	private EmployerApplicationUpdateService			updateService;

	@Autowired
	private EmployerApplicationListByMomentService		listMomentService;

	@Autowired
	private EmployerApplicationListByReferenceService	listReferenceService;

	@Autowired
	private EmployerApplicationListByStatusService		listStatusService;


	@PostConstruct
	private void initialise() {
		super.addCustomCommand(CustomCommand.LIST_MINE, BasicCommand.LIST, this.listMineService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addCustomCommand(CustomCommand.LIST_BY_MOMENT, BasicCommand.LIST, this.listMomentService);
		super.addCustomCommand(CustomCommand.LIST_BY_REFERENCE, BasicCommand.LIST, this.listReferenceService);
		super.addCustomCommand(CustomCommand.LIST_BY_STATUS, BasicCommand.LIST, this.listStatusService);
	}

}
