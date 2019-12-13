
package acme.features.authenticated.userThread;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/authenticated/")
public class AuthenticatedUsersThreadController extends AbstractController<Authenticated, Authenticated> {

	@Autowired
	private AuthenticatedUsersThreadListService		listUserService;

	@Autowired
	private AuthenticatedUsersThreadNoListService	listNoUserService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listUserService);
		super.addCustomCommand(CustomCommand.LIST_MINE, BasicCommand.LIST, this.listNoUserService);
	}

}
