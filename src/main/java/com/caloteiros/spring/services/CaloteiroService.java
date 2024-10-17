package com.caloteiros.spring.services;

import com.caloteiros.spring.exceptions.CaloteiroNotFoundException;
import com.caloteiros.spring.models.Caloteiro;
import com.caloteiros.spring.repositories.CaloteiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaloteiroService {

    @Autowired
    CaloteiroRepository caloteiroRepository;

    public List<Caloteiro> findAll() {
        try {
            return caloteiroRepository.findAll();
        } catch (DataAccessException e) {
            throw e;
        }
    }

    public Optional<Caloteiro> findById(Long id) {
        try {
            return Optional.ofNullable(caloteiroRepository.findById(id)
                    .orElseThrow(() -> new CaloteiroNotFoundException("Caloteiro não encontrado com o ID: " + id)));
        } catch (DataAccessException e) {
            throw e;
        }
    }

    public void create(Caloteiro caloteiro) {
        try {
            caloteiroRepository.save(caloteiro);
        } catch (DataAccessException e) {
            throw e;
        }
    }

    public void deleteById(Long id) {
        try {
            Optional<Caloteiro> optionalCaloteiro = caloteiroRepository.findById(id);
            if (optionalCaloteiro.isEmpty()) {
                throw new CaloteiroNotFoundException("Caloteiro não encontrado com o ID: " + id);
            }
            caloteiroRepository.deleteById(id);
        } catch (DataAccessException e) {
            throw e;
        }
    }

    public void update(Long id, Caloteiro updateCaloteiro) {
        try {
            Caloteiro caloteiro = caloteiroRepository.findById(id)
                    .orElseThrow(() -> new CaloteiroNotFoundException("Caloteiro não encontrado com o ID: " + id));

            caloteiro.setName(updateCaloteiro.getName());
            caloteiro.setEmail(updateCaloteiro.getEmail());
            caloteiro.setDebt(updateCaloteiro.getDebt());
            caloteiro.setDebtDate(updateCaloteiro.getDebtDate());

            caloteiroRepository.update(caloteiro);
        } catch (DataAccessException e) {
            throw e;
        }
    }

}
