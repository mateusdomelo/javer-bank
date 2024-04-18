package io.github.mateusdomelo.javer.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.mateusdomelo.javer.validation.NumericBalance;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Generated;

@Data
@Generated
public class Cliente {
    private Long id;

    @NotEmpty(message = "{campo.nome.vazio}")
    private String nome;

    @NotEmpty(message = "{campo.telefone.vazio}")
    private String telefone;

    @NotNull(message = "{campo.correntista.vazio}")
    private boolean correntista;

    @JsonIgnore
    private float scoreCredito;

    @JsonProperty(value = "saldo_cc")
    @NumericBalance(message = "O valor mínimo do 'saldo' é R$0.00")
    private float saldoCc;

    protected static float taxaScoreCredito = 0.1f;

    public float getScoreCredito() {
        return saldoCc * taxaScoreCredito;
    }

    public void setScoreCredito(float saldo) {
        scoreCredito = saldo * taxaScoreCredito;
    }
}
