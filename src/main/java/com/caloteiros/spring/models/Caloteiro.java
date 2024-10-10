package com.caloteiros.spring.models;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Caloteiro {

    private Long id;

    private String name;
    private String email;
    private BigDecimal debt;
    private LocalDate debtDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Caloteiro{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", debt=" + debt +
                ", debtDate=" + debtDate +
                '}';
    }
}