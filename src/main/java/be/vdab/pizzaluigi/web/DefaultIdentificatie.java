package be.vdab.pizzaluigi.web;

import java.io.Serializable;

import javax.validation.constraints.Email;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
class DefaultIdentificatie implements Identificatie, Serializable {
	private static final long serialVersionUID = 1L;
	@Email
	private String emailAdres;
	
	@Override
	public String getEmailAdres() {
		return emailAdres;
	}

	@Override
	public void setEmailAdres(String emailAdres) {
		this.emailAdres = emailAdres;
	}
}
