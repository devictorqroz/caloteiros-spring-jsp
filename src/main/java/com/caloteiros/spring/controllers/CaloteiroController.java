package com.caloteiros.spring.controllers;

import com.caloteiros.spring.models.Caloteiro;
import com.caloteiros.spring.services.CaloteiroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/caloteiros")
public class CaloteiroController {

    private final CaloteiroService caloteiroService;

    public CaloteiroController(CaloteiroService caloteiroService) {
        this.caloteiroService = caloteiroService;
    }

    @GetMapping("/{id}")
    public Caloteiro findById(@PathVariable Long id) {
        var caloteiro = caloteiroService.findById(id);
        if (caloteiro.isEmpty()) {
            throw new RuntimeException();
        }
        return caloteiro.get();
    }

    @GetMapping
    public List<Caloteiro> findAll() {
        return caloteiroService.findAll();
    }

    @PostMapping
    public void create(@RequestBody Caloteiro caloteiro) {
        caloteiroService.create(caloteiro);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        caloteiroService.deleteById(id);
    }

    @PutMapping
    public void update(@RequestBody Caloteiro caloteiro) {
        caloteiroService.update(caloteiro);
    }

}
