package com.caloteiros.spring.repositories;

import com.caloteiros.spring.models.Caloteiro;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CaloteiroRepository {

    private final JdbcClient jdbcClient;

    public CaloteiroRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public void create(Caloteiro caloteiro) {
        jdbcClient.sql("""
                INSERT INTO caloteiro (name, email, debt, debtDate) 
                VALUES (:name, :email, :debt, :debtDate)
            """)
            .param("name", caloteiro.getName())
            .param("email", caloteiro.getEmail())
            .param("debt", caloteiro.getDebt())
            .param("debtDate", caloteiro.getDebtDate())
            .update();
    }

    public Optional<Caloteiro> findById(Long id) {
        return jdbcClient
            .sql("SELECT * FROM caloteiro WHERE id = :id")
            .param("id", id)
            .query(Caloteiro.class)
            .optional();
    }

    public List<Caloteiro> findAll() {
        return jdbcClient
            .sql("SELECT * FROM caloteiro")
            .query(Caloteiro.class)
            .list();
    }

    public void delete(Long id) {
        jdbcClient
                .sql("DELETE FROM caloteiro WHERE id = :id")
                .param("id", id)
                .update();
    }

    public int update(Caloteiro caloteiro) {
        return jdbcClient
                .sql("""
                        UPDATE caloteiro SET name = :name, email = :email,
                        debt = :debt, debtDate = :debtDate WHERE id = :id
                    """)
                .param("name", caloteiro.getName())
                .param("email", caloteiro.getEmail())
                .param("debt", caloteiro.getDebt())
                .param("debtDate", caloteiro.getDebtDate())
                .param("id", caloteiro.getId())
                .update();
    }

}