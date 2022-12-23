package com.example.jdbc_api.Controller;

import com.example.jdbc_api.Repository.Dao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class DaoController {
    private final Dao daoRepository;

    public DaoController(Dao daoRepository) {
        this.daoRepository = daoRepository;
    }

    @GetMapping("fetch-product")
    public ResponseEntity<List<String>> getProduct(@RequestParam String name) {
        List<String> names = daoRepository.getProductNames(name);
        return ResponseEntity.ok().body(names);
    }
}