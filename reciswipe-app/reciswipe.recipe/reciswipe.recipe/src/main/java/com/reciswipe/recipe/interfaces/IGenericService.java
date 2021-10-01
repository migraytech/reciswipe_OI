package com.reciswipe.recipe.interfaces;


import java.util.List;

public interface IGenericService <T> {

    T create(T object);
    List<T> read();
    T  update(T object);
    boolean delete(T object);
}
