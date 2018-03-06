package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class AuthController {
	@RequestMapping(value="/login")
	public String login(ModelMap model) {
		model.addAttribute("title", "LOGIN");
		return "auth.login";
	}
}
