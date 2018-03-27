package be.vdab.pizzaluigi.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("headers")
class RequestHeaderController {
	private final static String REQUEST_HEADER_VIEW ="headers";
	@GetMapping
	ModelAndView opWindows(@RequestHeader("user-agent") String userAgent) {
		return new ModelAndView(REQUEST_HEADER_VIEW,"opWindows",userAgent.toLowerCase().contains("windows"));
	}
}