package be.vdab.pizzaluigi.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import be.vdab.pizzaluigi.entities.Pizza;
import be.vdab.pizzaluigi.exceptions.PizzaNietGevondenException;

@RunWith(SpringRunner.class)
@JdbcTest 
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Import(JdbcPizzaRepository.class)
@Sql("/insertPizza.sql")
public class JdbcRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	private JdbcPizzaRepository repository;
	//private long ideetje = super.jdbcTemplate.queryForObject("select id from pizzas where naam = 'test'",Long.class);
	
	private long idVanTestPizza() {
		return super.jdbcTemplate.queryForObject("select id from pizza where naam='test'", Long.class);
	}
	
	@Test
	public void create() {
		int aantalPizzas = super.countRowsInTable("pizzas");
		Pizza pizza = new Pizza("test",BigDecimal.TEN,false);
		repository.create(pizza);
		assertNotEquals(0,pizza.getId()); //auto-Id toegekend
		assertEquals(aantalPizzas+1,this.countRowsInTable("pizzas")); //er is een extra rij in de database
		assertEquals(1,super.countRowsInTableWhere("pizzas", "id="+pizza.getId())); //er is 1 rij met de nieuwe id toegekend
	}
	
	@Test
	public void readBestaandePizza() {
		assertEquals("test",repository.read(idVanTestPizza()).get().getNaam());
	}
	
	@Test
	public void readOnbestaandePizzaNiet() {
		assertFalse(repository.read(-1L).isPresent());
	}
	
	@Test
	public void updateBestaandePizza() {
		Pizza pizza = new Pizza(idVanTestPizza(),"test",BigDecimal.ONE,false);
		repository.update(pizza);
		assertEquals(0,BigDecimal.ONE.compareTo(
			super.jdbcTemplate.queryForObject("select prijs from pizzas where id=?",BigDecimal.class,idVanTestPizza())));
	}
	
	@Test (expected = PizzaNietGevondenException.class)
	public void updateOnbestaandePizzaNiet() {
		Pizza pizza = new Pizza(-1,"test",BigDecimal.TEN,false);
		repository.update(pizza);
	}
	
	@Test
	public void delete() {
		int aantalPizzas = super.countRowsInTable("pizzas");
		long testPizzaId = idVanTestPizza();
		repository.delete(testPizzaId);
		assertEquals(aantalPizzas-1,super.countRowsInTable("pizzas"));
		assertEquals(0,super.countRowsInTableWhere("pizzas","id="+testPizzaId));
	}
	
	@Test
	public void findAll() {
		List<Pizza> pizzas = repository.findAll();
		assertEquals(pizzas.size(),super.countRowsInTable("pizzas"));
		long vorigeId = 0;
		for (Pizza pizza : pizzas) {
			assertTrue(pizza.getId() > vorigeId);
			vorigeId = pizza.getId();
		}
	}
	
	@Test
	public void findByPrijsBetween() {
		List<Pizza> pizzas = repository.findByPrijsBetween(BigDecimal.ONE,BigDecimal.TEN);
		assertEquals(super.countRowsInTableWhere("pizzas","prijs between 1 and 10"),pizzas.size());
		BigDecimal vorigePrijs = BigDecimal.ZERO;
		for (Pizza pizza : pizzas) {
			assertTrue(pizza.getPrijs().compareTo(BigDecimal.ONE) >= 0);
			assertTrue(pizza.getPrijs().compareTo(BigDecimal.TEN) <= 0);
			assertTrue(pizza.getPrijs().compareTo(vorigePrijs) >= 0);
			vorigePrijs = pizza.getPrijs();
		}
	}

	@Test
	public void findAantalPizzas() {
		assertEquals(super.countRowsInTable("pizzas"),repository.findAantalPizzas());
	}

	@Test
	public void findUniekePrijzen() {
		List<BigDecimal> prijzen = repository.findUniekePrijzen();
		long aantalPrijzen = super.jdbcTemplate.queryForObject("select count(distinct prijs) from pizzas",Long.class);
		assertEquals(aantalPrijzen,prijzen.size());
		BigDecimal vorigePrijs = BigDecimal.valueOf(-1);
		for (BigDecimal prijs : prijzen) {
			assertTrue(prijs.compareTo(vorigePrijs)>=0);
			vorigePrijs = prijs;
		}
	}

	@Test
	public void findByPrijs() {
		List<Pizza> pizzas = repository.findByPrijs(BigDecimal.TEN);
		assertEquals(super.countRowsInTableWhere("pizzas","prijs = 10"),pizzas.size());
	}
}
