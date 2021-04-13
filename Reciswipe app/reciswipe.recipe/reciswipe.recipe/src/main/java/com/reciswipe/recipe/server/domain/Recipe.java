package com.reciswipe.recipe.server.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue
    private Long id;


}
