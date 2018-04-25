package be.vdab.pizzaluigi.valueobjects;

import javax.validation.Valid;

import org.hibernate.validator.constraints.Range;

public class Persoon {
	private String voornaam;
	private String familienaam;
	@Range(min = 0, max = 69)
	private int aantalKinderen;
	private boolean gehuwd;
	@Valid
	private Adres adres;

	public Persoon() {
	}
	
	public Persoon(String voornaam, String familienaam, int aantalKinderen, boolean gehuwd, Adres adres) {
		this.voornaam = voornaam;
		this.familienaam = familienaam;
		this.aantalKinderen = aantalKinderen;
		this.gehuwd = gehuwd;
		this.adres = adres;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public String getFamilienaam() {
		return familienaam;
	}

	public int getAantalKinderen() {
		return aantalKinderen;
	}

	public boolean isGehuwd() {
		return gehuwd;
	}
	
	public Adres getAdres() {
		return adres;
	}

	public String getNaam() {
		return voornaam+" "+familienaam;
	}
	
}
