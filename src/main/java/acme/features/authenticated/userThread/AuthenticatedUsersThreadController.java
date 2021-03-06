
package acme.features.authenticated.userThread;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.threads.UserThread;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/user-thread/")
public class AuthenticatedUsersThreadController extends AbstractController<Authenticated, UserThread> {

	@Autowired
	private AuthenticatedUsersThreadListService		listUserService;

	@Autowired
	private AuthenticatedUsersThreadShowService		showService;

	@Autowired
	private AuthenticatedUserThreadDeleteService	deleteService;

	@Autowired
	private AuthenticatedUserThreadCreateService	createService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listUserService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
	}

}
