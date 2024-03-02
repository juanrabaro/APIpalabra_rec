package com.example.ApiPalabra.services;

import com.example.ApiPalabra.models.PruebaModel;
import com.example.ApiPalabra.repositories.PruebaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PruebaService {

  @Autowired
  private final PruebaRepository IPruebaRepository;


  @PostMapping("/prueba")
  public PruebaModel createPruebaModel() {
    PruebaModel pruebaModel = new PruebaModel();
    pruebaModel.setName("Test");
    return IPruebaRepository.save(pruebaModel);
  }
}