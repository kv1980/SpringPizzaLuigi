package be.vdab.pizzaluigi.entities;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Pizza {
	private long id;
	@NotBlank
	private String naam;
	@NotNull 
	@Min(0)
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

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public void setPrijs(BigDecimal prijs) {
		this.prijs = prijs;
	}

	public void setPikant(boolean pikant) {
		this.pikant = pikant;
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
