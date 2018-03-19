package be.vdab.pizzaluigi.valueobjects;

public class Persoon {
	private String voornaam;
	private String familienaam;
	private int aantalKinderen;
	private boolean gehuwd;
	private Adres adres;
		
	public Persoon(String voornaam, String familienaam, int aantalKinderen, boolean gehuwd, Adres adres) {
		this.voornaam = voornaam;
		this.familienaam = familienaam;
		this.aantalKinderen = aantalKinderen;
		this.gehuwd = gehuwd;
		this.adres = adres;
	}

	public Persoon() {
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
