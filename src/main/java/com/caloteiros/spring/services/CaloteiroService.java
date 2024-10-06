package com.caloteiros.spring.services;

import com.caloteiros.spring.models.Caloteiro;
import com.caloteiros.spring.repositories.CaloteiroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaloteiroService {

    private final CaloteiroRepository caloteiroRepository;

    public CaloteiroService(CaloteiroRepository caloteiroRepository) {
        this.caloteiroRepository = caloteiroRepository;
    }

    public List<Caloteiro> findAll() {
        return caloteiroRepository.findAll();
    }

    public Optional<Caloteiro> findById(Long id) {
        return caloteiroRepository.findById(id);
    }

    public void create(Caloteiro caloteiro) {
        caloteiroRepository.create(caloteiro);
    }

    public void delete(Long id) {
        caloteiroRepository.delete(id);
    }

    public void update(Caloteiro caloteiro) {
        caloteiroRepository.update(caloteiro);
    }

}
