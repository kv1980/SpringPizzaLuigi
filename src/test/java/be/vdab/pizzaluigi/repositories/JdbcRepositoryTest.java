package be.vdab.pizzaluigi.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import java.math.BigDecimal;

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

@RunWith(SpringRunner.class)
@JdbcTest // roept enkel template en data-source op
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Import(JdbcPizzaRepository.class)
@Sql("/insertPizza.sql")
public class JdbcRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	private JdbcPizzaRepository repository;
	private long testPizzaId = super.jdbcTemplate.queryForObject("select id from pizzas where naam='test'", Long.class);
	
	@Test
	public void create() {
		int aantalPizzas = super.countRowsInTable("pizzas");
		Pizza pizza = new Pizza("test",BigDecimal.TEN,false);
		repository.create(pizza);
		assertNotEquals(0,pizza.getId()); //auto-Id toegekend
		assertEquals(aantalPizzas+1,this.countRowsInTable("pizzas")); //er is een extra rij in de database
		assertEquals(1,super.countRowsInTableWhere("pizzas", "id="+testPizzaId)); //er is 1 rij met de nieuwe id toegekend
	}
	
	@Test
	public void readBestaandePizza() {
		assertEquals("test",repository.read(testPizzaId).get().getNaam());
	}
	
	@Test
	public void readOnbestaandePizza() {
		assertFalse(repository.read(-1L).isPresent());
	}
	

	
	
}
