package be.vdab.pizzaluigi.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.pizzaluigi.services.EuroService;

public class PizzaControllerTest {
	private PizzaController controller;
	private EuroService dummyEuroService;
	
	@Before
	public void before() {
		dummyEuroService = Mockito.mock(EuroService.class);
		controller = new PizzaController(dummyEuroService);
	}
	
	@Test
	public void pizzasWerktSamenMetDeJuisteJSP() {
		ModelAndView modelAndView = controller.pizzas();
		assertEquals("pizzas",modelAndView.getViewName());
	}
	
	@Test
	public void pizzasGeeftPizzasAanJSP() {
		ModelAndView modelAndView = controller.pizzas();
		assertTrue(modelAndView.getModel().containsKey("pizzas"));
	}
	
	@Test
	public void pizzaWerktSamenMetDeJuisteJSP() {
		System.out.println("kiekeboe");
		ModelAndView modelAndView = controller.pizza(12);
		System.out.println("***"+modelAndView.getViewName());
		assertEquals("pizza",modelAndView.getViewName());
	}
	
	@Test
	public void pizzaGeeftPizzasAanJSP() {
		ModelAndView modelAndView = controller.pizza(12);
		assertTrue(modelAndView.getModel().containsKey("pizza"));
	}

}
