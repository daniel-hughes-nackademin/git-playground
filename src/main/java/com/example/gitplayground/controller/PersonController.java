package com.example.gitplayground.controller;

import com.example.gitplayground.model.Person;
import com.example.gitplayground.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable int id){
        return personService.findById(id);
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person){
        return personService.createPerson(person.getName());
    }
}
