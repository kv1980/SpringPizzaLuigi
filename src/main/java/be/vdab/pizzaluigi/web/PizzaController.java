package be.vdab.pizzaluigi.web;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.pizzaluigi.entities.Pizza;

@Controller
@RequestMapping("pizzas")
class PizzaController {
	private final static String PIZZAS_VIEW = "pizzas";
	private final static String PIZZA_VIEW = "pizza";
	private final static String PRIJZEN_VIEW = "prijzen";
	private final Map<Long,Pizza> pizzas = new LinkedHashMap<>();
	
	PizzaController(){
		pizzas.put(12L, new Pizza(12,"Prosciutto",BigDecimal.valueOf(4),true));
		pizzas.put(14L, new Pizza(14,"Margherita",BigDecimal.valueOf(5),false));
		pizzas.put(17L, new Pizza(17,"Calzone",BigDecimal.valueOf(4),false));
		pizzas.put(23L, new Pizza(17,"Fungi & Olive",BigDecimal.valueOf(5),false));
	}
	
	@GetMapping
	ModelAndView pizzas() {
		return new ModelAndView(PIZZAS_VIEW,"pizzas",pizzas);
	}
	
	@GetMapping("{id}")
	ModelAndView pizza(@PathVariable long id) {
		return new ModelAndView(PIZZA_VIEW,"pizza",pizzas.get(id));
	}
	
	@GetMapping("prijzen")
	ModelAndView prijzen() {
		return new ModelAndView(PRIJZEN_VIEW,"prijzen",
				pizzas.values().stream().map(pizza -> pizza.getPrijs()).distinct().collect(Collectors.toSet()));
	}
	
	@GetMapping(params="prijs")
	ModelAndView pizzasVanPrijs(BigDecimal prijs) {
		return new ModelAndView(PRIJZEN_VIEW, "pizzas",
				pizzas.values().stream().filter(pizza -> pizza.getPrijs().equals(prijs)).collect(Collectors.toList()))
		.addObject("prijs", prijs)
		.addObject("prijzen", 
				pizzas.values().stream().map(pizza -> pizza.getPrijs()).distinct().collect(Collectors.toSet()));
	}	
	

	
	
}
