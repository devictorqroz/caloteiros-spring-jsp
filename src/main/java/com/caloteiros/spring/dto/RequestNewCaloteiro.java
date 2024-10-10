package com.caloteiros.spring.dto;

import com.caloteiros.spring.models.Caloteiro;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RequestNewCaloteiro {

    private String name;
    private String email;
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
