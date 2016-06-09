package be.vdab.util;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class InputValidator {
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	public static final long MINIMUM_SALARIS = 500L;
	
	private InputValidator() {};
	
	/**
	 * Valideert een String op niet-null en niet leeg te zijn. De teruggegeven String is dezelfde als de parameter.  
	 * 
	 * @param string						De te controleren String.
	 * @return								De String die werd meegegeven als parameter.
	 * @throws IllegalArgumentException		Wordt geworpen wanneer de parameter een null-reference of een lege ("") String was.
	 */
	public static String checkNotNullOrEmpty(String string) throws IllegalArgumentException {
		if (string == null || string.equals("")) {
			throw new IllegalArgumentException("Opgegeven string mag niet null of leeg zijn.");
		}
		return string;
	}
	
	public static String checkValidEmailAddress(String string) throws IllegalArgumentException {
		checkNotNullOrEmpty(string);
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(string);
		if (!matcher.find()) {
			throw new IllegalArgumentException("Ongeldig e-mail adres formaat");
		}
		return string;
	}

	public static BigDecimal checkValidSalaris(BigDecimal salaris) throws IllegalArgumentException {
		if (salaris == null || salaris.compareTo(BigDecimal.valueOf(MINIMUM_SALARIS)) < 0) {
			throw new IllegalArgumentException("Salaris ");
		}
		return salaris;
	}
	
}
