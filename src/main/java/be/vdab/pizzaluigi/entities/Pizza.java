package be.vdab.pizzaluigi.entities;

import java.math.BigDecimal;

public class Pizza {
	private long id;
	private String naam;
	private BigDecimal prijs;
	private boolean pikant;
	
	public Pizza() {
	}

	public Pizza(long id, String naam, BigDecimal prijs, boolean pikant) {
		this.id = id;
		this.naam = naam;
		this.prijs = prijs;
		this.pikant = pikant;
	}
	
	public Pizza(String naam, BigDecimal prijs, boolean pikant) {
		this.naam = naam;
		this.prijs = prijs;
		this.pikant = pikant;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public String getNaam() {
		return naam;
	}

	public BigDecimal getPrijs() {
		return prijs;
	}

	public boolean isPikant() {
		return pikant;
	}	

}
