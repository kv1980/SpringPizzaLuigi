package be.vdab.pizzaluigi.repositories;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import be.vdab.pizzaluigi.entities.Pizza;

@Repository
public class JdbcPizzaRepository implements PizzaRepository {
	private final NamedParameterJdbcTemplate template;
	private final SimpleJdbcInsert insert;
	private static final String SELECT_AANTAL_PIZZAS = "select count(*) from pizzas";
	private static final String DELETE_PIZZA = "deleted from pizzas where id=:id";
	private static final String UPDATE_PIZZA = "update pizzas set naam=:naam, prijs=:prijs, pikant=:pikant where id=:id";

	public JdbcPizzaRepository(NamedParameterJdbcTemplate template, DataSource dataSource) {
		this.template = template;
		this.insert = new SimpleJdbcInsert(dataSource);
		insert.withTableName("pizzas");
		insert.usingGeneratedKeyColumns("id");
	}
	
	

	@Override
	public void create(Pizza pizza) {
		Map<String, Object> kolomWaarden = new HashMap<>();
		kolomWaarden.put("naam",pizza.getNaam());
		kolomWaarden.put("prijs",pizza.getPrijs());
		kolomWaarden.put("pikant",pizza.isPikant());
		Number id = insert.executeAndReturnKey(kolomWaarden);
		pizza.setId(id.longValue());
	}

//	@Override
//	public Optional<Pizza> read(long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public void update(Pizza pizza) {
		Map<String,Object> parameters = new HashMap<>();
		parameters.put("naam", pizza.getNaam());
		parameters.put("prijs", pizza.getPrijs());
		parameters.put("pikant", pizza.isPikant());
		parameters.put("id",pizza.getId());
		template.update(UPDATE_PIZZA, parameters);
		
	}

	@Override
	public void delete(long id) {
		template.update(DELETE_PIZZA,Collections.singletonMap("id",id));
		
	}

//	@Override
//	public List<Pizza> findAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public List<Pizza> findByPrijsBetween(BigDecimal vanPrijs, BigDecimal totPrijs) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public long findAantalPizzas() {
		return template.queryForObject(SELECT_AANTAL_PIZZAS,Collections.emptyMap(),Long.class);
	}

//	@Override
//	public List<BigDecimal> findUniekePrijzen() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public List<Pizza> findByPrijs(BigDecimal prijs) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
