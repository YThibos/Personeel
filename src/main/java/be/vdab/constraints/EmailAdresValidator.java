package be.vdab.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import be.vdab.util.InputValidator;

class EmailAdresValidator implements ConstraintValidator<EmailPattern, String>{

	@Override
	public void initialize(EmailPattern constraintAnnotation) {}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return InputValidator.VALID_EMAIL_ADDRESS_REGEX.matcher(value).matches();
	}
	
}
