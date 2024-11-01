package com.caloteiros.spring.services.caloteiro;

import com.caloteiros.spring.exceptions.CaloteiroNotFoundException;
import com.caloteiros.spring.models.caloteiro.Caloteiro;
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

    public List<Caloteiro> findAllByUserId(Long userId) {
        try {
            return caloteiroRepository.findAllByUserId(userId);
        } catch (DataAccessException e) {
            throw e;
        }
    }

    public Optional<Caloteiro> findById(Long caloteiroId, Long userId) {
        try {
            return Optional.ofNullable(caloteiroRepository.findById(caloteiroId, userId)
                    .orElseThrow(() -> new CaloteiroNotFoundException("Caloteiro não encontrado com o ID: " + caloteiroId)));
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

    public void deleteById(Long caloteiroId, Long userId) {
        try {
            Optional<Caloteiro> optionalCaloteiro = caloteiroRepository.findById(caloteiroId, userId);
            if (optionalCaloteiro.isEmpty()) {
                throw new CaloteiroNotFoundException("Caloteiro não encontrado com o ID: " + caloteiroId);
            }
            caloteiroRepository.deleteById(caloteiroId, userId);
        } catch (DataAccessException e) {
            throw e;
        }
    }

    public void update(Long id, Caloteiro updateCaloteiro) {

        Caloteiro caloteiro = caloteiroRepository.findById(id, updateCaloteiro.getUserId())
                .orElseThrow(() -> new CaloteiroNotFoundException("Caloteiro não encontrado com o ID: " + id));

        updateFields(caloteiro, updateCaloteiro);

        try {
            caloteiroRepository.update(caloteiro);
        } catch (DataAccessException e) {
            throw e;
        }
    }


    private void updateFields(Caloteiro caloteiro, Caloteiro updateCaloteiro) {
        caloteiro.setName(updateCaloteiro.getName());
        caloteiro.setEmail(updateCaloteiro.getEmail());
        caloteiro.setDebt(updateCaloteiro.getDebt());
        caloteiro.setDebtDate(updateCaloteiro.getDebtDate());
        caloteiro.setUserId(updateCaloteiro.getUserId());
    }
}
