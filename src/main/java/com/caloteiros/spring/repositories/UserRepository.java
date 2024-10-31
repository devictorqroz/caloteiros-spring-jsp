package com.caloteiros.spring.repositories;

import com.caloteiros.spring.models.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    @Autowired
    private JdbcClient jdbcClient;

    public void save(User user) {
        jdbcClient.sql("""
                INSERT INTO user (username, password, salt) 
                VALUES (:username, :password, :salt)
            """)
                .param("username", user.getUsername())
                .param("password", user.getPassword())
                .param("salt", user.getSalt())
                .update();
    }

    public List<User> findAll() {
        return jdbcClient
                .sql("SELECT * FROM user")
                .query(User.class)
                .list();
    }

    public void deleteByUsername(String username) {
        jdbcClient
                .sql("DELETE FROM user WHERE username = :username")
                .param("username", username)
                .update();
    }

    public void update(User user) {
        jdbcClient
                .sql("""
                UPDATE user 
                SET username = :username, password = :password, salt = :salt
                WHERE id = :id;
            """)
                .param("id", user.getId())
                .param("username", user.getUsername())
                .param("password", user.getPassword())
                .param("salt", user.getSalt())
                .update();
    }

    public Optional<User> findUserByUsername(String username) {
        return jdbcClient
                .sql("""
                    SELECT id, username, password, salt
                    FROM user
                    WHERE username = :username;
                """)
                .param("username", username)
                .query(User.class)
                .optional();
    }
}
