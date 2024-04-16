package io.github.mateusdomelo.javer.validation;

import io.github.mateusdomelo.javer.validation.constraint.NumericBalanceValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = NumericBalanceValidator.class)
public @interface NumericBalance {
    String message() default "Saldo inválido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
