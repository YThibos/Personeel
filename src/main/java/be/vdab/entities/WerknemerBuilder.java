package be.vdab.entities;

import java.math.BigDecimal;
import java.util.Objects;

import be.vdab.util.InputValidator;

public class WerknemerBuilder {
	
	private Werknemer werknemer;
	
	public WerknemerBuilder() {
		werknemer = new Werknemer();
	}
	
	public void setFamilienaam(String familienaam) throws IllegalArgumentException {
		werknemer.familienaam = InputValidator.checkNotNullOrEmpty(familienaam);
	}
	public void setVoornaam(String voornaam) throws IllegalArgumentException {
		werknemer.familienaam = InputValidator.checkNotNullOrEmpty(voornaam);
	}
	public void setEmail(String email) throws IllegalArgumentException {
		email = InputValidator.checkValidEmailAddress(email);
	}
	public void setSalaris(BigDecimal salaris) throws IllegalArgumentException {
		werknemer.salaris = InputValidator.checkValidSalaris(salaris);
	}
	public void setJobtitel(Jobtitel jobtitel) throws NullPointerException {
		Objects.requireNonNull(jobtitel, "Null referentie bij jobtitel tijdens het builden.");
		werknemer.jobtitel = jobtitel;
	}
	public Werknemer build() {
		return werknemer;
	}

}
