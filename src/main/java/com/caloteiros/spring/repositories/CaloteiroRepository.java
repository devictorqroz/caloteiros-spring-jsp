package com.caloteiros.spring.repositories;

import com.caloteiros.spring.models.caloteiro.Caloteiro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CaloteiroRepository {

    @Autowired
    private JdbcClient jdbcClient;

    public void save(Caloteiro caloteiro) {
        jdbcClient.sql("""
                INSERT INTO caloteiro (name, email, debt, debtDate, user_id) 
                VALUES (:name, :email, :debt, :debtDate, :userId)
            """)
            .param("name", caloteiro.getName())
            .param("email", caloteiro.getEmail())
            .param("debt", caloteiro.getDebt())
            .param("debtDate", caloteiro.getDebtDate())
            .param("userId", caloteiro.getUserId())
            .update();
    }

    public Optional<Caloteiro> findById(Long caloteiroId, Long userId) {
        return jdbcClient
            .sql("SELECT * FROM caloteiro WHERE id = :caloteiroId AND user_id = :userId;")
            .param("caloteiroId", caloteiroId)
            .param("userId", userId)
            .query(Caloteiro.class)
            .optional();
    }

    public List<Caloteiro> findAllByUserId(Long userId) {
        return jdbcClient
            .sql("SELECT * FROM caloteiro WHERE user_id = :userId")
            .param("userId", userId)
            .query(Caloteiro.class)
            .list();
    }

    public void deleteById(Long caloteiroId, Long userId) {
        jdbcClient
                .sql("DELETE FROM caloteiro WHERE id = :caloteiroId AND user_id = :userId")
                .param("caloteiroId", caloteiroId)
                .param("userId", userId)
                .update();
    }

    public void update(Caloteiro caloteiro) {
        jdbcClient
            .sql("""
                UPDATE caloteiro 
                SET name = :name, email = :email, debt = :debt, debtDate = :debtDate 
                WHERE id = :id
            """)
            .param("name", caloteiro.getName())
            .param("email", caloteiro.getEmail())
            .param("debt", caloteiro.getDebt())
            .param("debtDate", caloteiro.getDebtDate())
            .param("id", caloteiro.getId())
            .update();
    }
}
