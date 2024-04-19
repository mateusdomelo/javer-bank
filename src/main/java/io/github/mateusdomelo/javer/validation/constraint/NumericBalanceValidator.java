package io.github.mateusdomelo.javer.validation.constraint;

import io.github.mateusdomelo.javer.validation.NumericBalance;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NumericBalanceValidator implements ConstraintValidator<NumericBalance, Float> {
    @Override
    public void initialize(NumericBalance constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Float value, ConstraintValidatorContext context) {
        return value >= 0;
    }
}
