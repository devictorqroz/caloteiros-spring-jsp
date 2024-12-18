package com.caloteiros.spring.dto.caloteiro;

import com.caloteiros.spring.models.caloteiro.Caloteiro;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RequestNewCaloteiroDTO {

    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    @NotNull
    @DecimalMin("1.0")
    private BigDecimal debt;
    private LocalDate debtDate;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getDebt() {
        return debt;
    }

    public void setDebt(BigDecimal debt) {
        this.debt = debt;
    }

    public LocalDate getDebtDate() {
        return debtDate;
    }

    public void setDebtDate(LocalDate debtDate) {
        this.debtDate = debtDate;
    }


    public Caloteiro toCaloteiro() {
        Caloteiro caloteiro = new Caloteiro();
        caloteiro.setName(this.name);
        caloteiro.setEmail(this.email);
        caloteiro.setDebt(this.debt);
        caloteiro.setDebtDate(this.debtDate);
        return caloteiro;
    }

    @Override
    public String toString() {
        return "RequestNewCaloteiro{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", debt=" + debt +
                ", debtDate=" + debtDate +
                '}';
    }
}
