package com.example.springboottodoapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {
	private Logger logger = LoggerFactory.getLogger(getClass());
//	private AuthenticationService authenticationService;
//	
//	public WelcomeController(AuthenticationService authenticationService) {
//		super();
//		this.authenticationService = authenticationService;
//	}

	@GetMapping("/")
	public String gotoWelcomePage(ModelMap model) {
		logger.debug("this is 15-l");
		model.addAttribute("name", getLoggedInUsername());
		return "welcome";
	}
	
	private String getLoggedInUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
//	@PostMapping("login")
//	public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap modelmap) {
//		logger.debug("this is welcome");
//		
//		// authentication 
//		if(authenticationService.authenticate(name, password)) {
//			logger.info("** Welcome page **");
//			modelmap.put("name", name);
//			return "welcome";
//		} else {
//			logger.info("** login page **");
//			modelmap.put("errorMessage", "Username or password incorrect");
//			return "login";
//		}
//		
//	}
}
