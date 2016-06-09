package be.vdab.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EmailAdresValidator.class})
public @interface EmailPattern {
	
	String message() default "{be.vdab.constraints.EmailPattern}"; 
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};

}
