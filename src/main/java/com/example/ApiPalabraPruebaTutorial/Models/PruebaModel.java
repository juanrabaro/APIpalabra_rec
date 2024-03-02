package com.example.ApiPalabraPruebaTutorial.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="pruebaTabla")
@Data
public class PruebaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;
}
