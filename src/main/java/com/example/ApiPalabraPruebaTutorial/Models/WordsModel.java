package com.example.ApiPalabraPruebaTutorial.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "words")
@Data
public class WordsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_word;

    @Column(nullable = false, length = 45)
    private String words;
}
