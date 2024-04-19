package io.github.mateusdomelo.javer.validation.constraint;

import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NumericBalanceValidatorTest {
    @MockBean
    private ConstraintValidatorContext constraintMock;

    @InjectMocks
    private NumericBalanceValidator validator;

    @Test
    void isValid_WithMinimumValue_ShouldReturnTrue() {
        /* Actions */
        boolean result = validator.isValid(0f, constraintMock);

        /* Verifications */
        assertTrue(result);
    }

    @Test
    void isValid_WithInvalidValue_ShouldReturnFalse() {
        /* Actions */
        boolean result = validator.isValid(-0.01f, constraintMock);

        /* Verifications */
        assertFalse(result);
    }
}