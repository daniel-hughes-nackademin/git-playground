package com.example.gitplayground.service;

import com.example.gitplayground.model.Person;

public interface PersonService {
    Person createPerson(String name);

    Person findById(int id);
}
