package be.vdab.pizzaluigi.web;

import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //@RestController indien er geen JSP bij hoort
@RequestMapping("/")
class IndexController {
	@GetMapping
	ModelAndView index() {
		String boodschap;
		int uur = LocalTime.now().getHour();
		if (uur < 12) {
			boodschap = "Een zeer goedemorgen";
		} else if (uur < 18) {
			boodschap = "Een zeer goedemiddag";
		} else {
			boodschap = "Een zeer goedeavond";
		}
		return new ModelAndView("/WEB-INF/JSP/index.jsp","boodschap",boodschap);
	}
}
