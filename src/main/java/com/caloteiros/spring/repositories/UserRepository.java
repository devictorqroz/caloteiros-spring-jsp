package com.caloteiros.spring.repositories;

import com.caloteiros.spring.models.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private JdbcClient jdbcClient;

    public void save(User user) {
        jdbcClient.sql("""
                INSERT INTO user (username, password) 
                VALUES (:username, :password)
            """)
                .param("username", user.getUsername())
                .param("password", user.getPassword())
                .update();
    }

    public User findByUsername(String username) {
        return jdbcClient
                .sql("SELECT * FROM user WHERE username = :username")
                .param("username", username)
                .query(rs -> {
                    String userId = rs.getString("id");
                    String usernameFromDb = rs.getString("username");
                    String passwordFromDb = rs.getString("password");

                    User user = new User(usernameFromDb, passwordFromDb);
                    user.setId(Long.valueOf(userId));

                    return user;
                });
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
                SET username = :username, password = :password
                WHERE id = :id;
            """)
                .param("id", user.getId())
                .param("username", user.getUsername())
                .param("password", user.getPassword())
                .update();
    }

    public boolean userExists(User user) {
        return jdbcClient
                .sql("""
                    SELECT 1
                    FROM user
                    WHERE username = :username;
                """)
                .param("username", user.getUsername())
                .query(Boolean.class)
                .optional()
                .orElse(false);
    }
}
