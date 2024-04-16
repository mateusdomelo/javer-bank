package io.github.mateusdomelo.javer.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mateusdomelo.javer.validation.NumericBalance;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.math.BigDecimal;

@Data
public class Cliente {
    private Long id;

    @NotEmpty(message = "{campo.nome.vazio}")
    private String nome;

    @NotEmpty(message = "{campo.telefone.vazio}")
    private String telefone;

    @NotNull(message = "{campo.correntista.vazio}")
    private boolean correntista;

    @Setter(AccessLevel.NONE)
    @JsonIgnore
    private BigDecimal scoreCredito;

    @JsonProperty(value = "saldo_cc")
    @Column(name = "saldo_cc")
    @NumericBalance(message = "O valor mínimo do 'saldo' é R$0.00")
    private BigDecimal saldoCc;

    protected static float taxaScoreCredito = 0.1f;

    public float getScoreCredito() {
        return saldoCc.multiply(new BigDecimal(taxaScoreCredito)).floatValue();
    }
}
