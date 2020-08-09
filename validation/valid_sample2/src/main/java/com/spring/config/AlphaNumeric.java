/**
 * 
 */
package com.spring.config;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;

@Documented
@Retention(RUNTIME)
@Constraint(validatedBy= {})
@Target({ FIELD, METHOD, PARAMETER, CONSTRUCTOR, ANNOTATION_TYPE })
@ReportAsSingleViolation
@Pattern(regexp="[a-zA-Z0-9+]*")
/**
 * @author parkjinsu
 *
 */
public @interface AlphaNumeric {
	String message() default "{com.spring.config.AlphaNumeric.message}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
	@Target({ FIELD, METHOD, PARAMETER, CONSTRUCTOR, ANNOTATION_TYPE })
	@Retention(RUNTIME)
	@Documented
	public @interface List{
		AlphaNumeric[] value();
	}
}
