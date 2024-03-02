package com.example.ApiPalabraPruebaTutorial.Controllers;

import com.example.ApiPalabraPruebaTutorial.Models.PruebaModel;
import com.example.ApiPalabraPruebaTutorial.Repositories.PruebaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/prueba/{id}")
    public ResponseEntity<?> getPruebaPorId(@PathVariable Integer id) {
        assert IpruebaRepository != null;
        PruebaModel prueba = IpruebaRepository.findById(Long.valueOf(id)).orElse(null);
        if (prueba == null) {
            return new ResponseEntity<>("No se encontró la prueba con id " + id, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(prueba, HttpStatus.OK);
        }
    }

    @PostMapping("/prueba")
    public PruebaModel createPrueba(@RequestBody PruebaModel prueba) {
        assert IpruebaRepository != null;
        return IpruebaRepository.save(prueba);
    }

    @PutMapping("/prueba/{id}")
    public PruebaModel updatePrueba(@PathVariable Integer id, @RequestBody PruebaModel prueba) {
        assert IpruebaRepository != null;
        PruebaModel pruebaActual = IpruebaRepository.findById(Long.valueOf(id)).orElse(null);
        assert pruebaActual != null;
        pruebaActual.setName(prueba.getName());
        return IpruebaRepository.save(pruebaActual);
    }

    @DeleteMapping("/prueba/{id}")
    public String deletePrueba(@PathVariable Integer id) {
        assert IpruebaRepository != null;
        PruebaModel pruebaABorrar = IpruebaRepository.findById(Long.valueOf(id)).orElse(null);
        if (pruebaABorrar == null) {
            return "No se pudo eliminar la prueba con id " + id;
        } else {
            IpruebaRepository.deleteById(Long.valueOf(id));
            return "Prueba con id " + id + " eliminada exitosamente";
        }
    }
}
