package nortal.lab.security.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PublicPage {

	@RequestMapping("/public")
	public String index() {
		return "public";
	}
	
	
}
