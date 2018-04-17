package be.vdab.pizzaluigi.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.pizzaluigi.services.EuroService;


@RunWith(MockitoJUnitRunner.class)
public class PizzaControllerTest {
	private PizzaController controller;
	@Mock private EuroService dummyEuroService;
	
	@Before
	public void before() {
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
		ModelAndView modelAndView = controller.pizza(12);
		assertEquals("pizza",modelAndView.getViewName());
	}
	
	@Test
	public void pizzaGeeftPizzasAanJSP() {
		ModelAndView modelAndView = controller.pizza(12);
		assertTrue(modelAndView.getModel().containsKey("pizza"));
	}

}
