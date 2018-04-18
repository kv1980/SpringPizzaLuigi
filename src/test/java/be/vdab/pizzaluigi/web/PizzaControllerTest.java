package be.vdab.pizzaluigi.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.pizzaluigi.entities.Pizza;
import be.vdab.pizzaluigi.services.EuroService;
import be.vdab.pizzaluigi.services.PizzaService;


@RunWith(MockitoJUnitRunner.class)
public class PizzaControllerTest {
	private PizzaController controller;
	@Mock 
	private EuroService dummyEuroService;
	@Mock 
	private PizzaService dummyPizzaService;
	
	@Before
	public void before() {
		when(dummyPizzaService.read(1))
			.thenReturn(Optional.ofNullable(new Pizza(1,"test",BigDecimal.ONE,true)));
		controller = new PizzaController(dummyEuroService,dummyPizzaService);
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
