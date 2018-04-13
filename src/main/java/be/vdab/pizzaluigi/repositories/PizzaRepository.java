package be.vdab.pizzaluigi.repositories;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import be.vdab.pizzaluigi.entities.Pizza;

public interface PizzaRepository {
	//CRUD
	void create(Pizza pizza);
	Optional<Pizza> read(long id);
	void update(Pizza pizza);
	void delete(long id);
	
	//find
	List<Pizza> findAll();
	List<Pizza> findByPrijsBetween(BigDecimal vanPrijs, BigDecimal totPrijs);
	long findAantalPizzas();
	List<BigDecimal> findUniekePrijzen();
	List<Pizza> findByPrijs(BigDecimal prijs);
}
