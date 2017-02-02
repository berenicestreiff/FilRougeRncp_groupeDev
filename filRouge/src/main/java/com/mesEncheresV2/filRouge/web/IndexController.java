package com.mesEncheresV2.filRouge.web;

import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value="/")
public class IndexController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String redirectToPublic() {
		return "redirect:/public/";
	}
	
	@RequestMapping(value = "/admin/", method = RequestMethod.GET)
	public String vueAdmin(Model model, Principal utilisateur) {
		model.addAttribute("message",
							"bienvenue venerable admin : " + utilisateur.getName());
		
		return "welcome";
	}
	
	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public String vueUser(Model model, Principal utilisateur) {
		model.addAttribute("message",
							"bienvenue cher utilisateur : " + utilisateur.getName());
		
		return "welcome";
	}

	@RequestMapping(value = "/public/", method = RequestMethod.GET)
	public String vuePublic(Model model, Principal utilisateur) {
		if (utilisateur != null)
			model.addAttribute("message",
							"ouuii, c'est pour quoi ?  : " + utilisateur.getName());
		else
			model.addAttribute("message", "ouuii, c'est pour quoi ?");
		
		return "welcome";
	}

	
	
	
	

}