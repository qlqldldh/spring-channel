package com.spring.config;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy= {EqualsPropertyValuesValidator.class})
@Retention(RUNTIME)
@Target({ TYPE, ANNOTATION_TYPE })
public @interface EqualsPropertyValues {
	String message() default "{com.spring.config.EqualsPropertyValues.message}";
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
	String property();
	String comparingProperty();
	
	@Documented
	@Retention(RUNTIME)
	@Target({TYPE, ANNOTATION_TYPE})
	public @interface List{
		EqualsPropertyValues[] value();
	}
}
