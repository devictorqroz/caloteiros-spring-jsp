package com.caloteiros.spring.services;

import com.caloteiros.spring.models.Caloteiro;
import com.caloteiros.spring.repositories.CaloteiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaloteiroService {

    @Autowired
    CaloteiroRepository caloteiroRepository;


    public List<Caloteiro> findAll() {
        return caloteiroRepository.findAll();
    }

    public Optional<Caloteiro> findById(Long id) {
        return caloteiroRepository.findById(id);
    }

    public void create(Caloteiro caloteiro) {
        caloteiroRepository.save(caloteiro);
    }

    public void deleteById(Long id) {
        caloteiroRepository.deleteById(id);
    }

    public void update(Long id, Caloteiro updateCaloteiro) {
        Optional<Caloteiro> optionalCaloteiro = caloteiroRepository.findById(id);

        if (optionalCaloteiro.isPresent()) {
            Caloteiro caloteiro = optionalCaloteiro.get();

            caloteiro.setName(updateCaloteiro.getName());
            caloteiro.setEmail(updateCaloteiro.getEmail());
            caloteiro.setDebt(updateCaloteiro.getDebt());
            caloteiro.setDebtDate(updateCaloteiro.getDebtDate());

            caloteiroRepository.update(caloteiro);
        }
    }

}
