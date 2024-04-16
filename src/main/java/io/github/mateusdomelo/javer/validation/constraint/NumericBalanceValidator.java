package io.github.mateusdomelo.javer.validation.constraint;

import io.github.mateusdomelo.javer.validation.NumericBalance;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.math.BigDecimal;

public class NumericBalanceValidator implements ConstraintValidator<NumericBalance, BigDecimal> {
    @Override
    public void initialize(NumericBalance constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(BigDecimal value, ConstraintValidatorContext context) {
        return value != null && value.compareTo(BigDecimal.ZERO) >= 0;
    }
}
