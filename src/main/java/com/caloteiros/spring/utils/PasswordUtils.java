package com.caloteiros.spring.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordUtils {

    private static final SecureRandom secureRandom = new SecureRandom();

    public static String generateSalt() {
        byte[] salt = new byte[16]; // 128 bits
        secureRandom.nextBytes(salt);
        return String.format("%064x", new BigInteger(1, salt));
    }

    public static String passwordEncoder(String password, String salt) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(salt.getBytes());
            BigInteger hash = new BigInteger(1, messageDigest.digest(password.getBytes()));
            return String.format("%064x", hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao inicializar SHA-256", e);
        }
    }

    public static boolean matches(String loginPassword, String storedHash, String salt) {
        String hashedLoginPassword = passwordEncoder(loginPassword, salt);
        return hashedLoginPassword.equals(storedHash);
    }
}
