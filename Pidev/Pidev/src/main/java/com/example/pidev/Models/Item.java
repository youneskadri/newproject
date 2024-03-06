package com.example.pidev.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Item {
    private Long id;
    private String name;
    private int produit;
    private int prix ;
}
