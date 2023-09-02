package com.example.vorspiel_backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vorspiel_backend.entites.AbstractEntity;
import com.example.vorspiel_backend.repositories.Dao;


@Service
public abstract class AbstractService <E extends AbstractEntity> {
    
    @Autowired
    private Dao<E> dao;


    public Dao<E> getDao() {

        return this.dao;
    }
}