package com.example.ApiPalabraPruebaTutorial.Controllers;

import com.example.ApiPalabraPruebaTutorial.Models.PruebaModel;
import com.example.ApiPalabraPruebaTutorial.Repositories.PruebaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PruebaController {

    @Autowired
    private final PruebaRepository IpruebaRepository;

    public PruebaController() {
        IpruebaRepository = null;
    }

    @GetMapping("/prueba")
    public List<PruebaModel> getPrueba() {
        assert IpruebaRepository != null;
        return (List<PruebaModel>) IpruebaRepository.findAll();
    }
}
