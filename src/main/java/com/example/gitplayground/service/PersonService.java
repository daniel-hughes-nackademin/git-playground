package com.example.gitplayground.service;

import com.example.gitplayground.model.Person;
import com.example.gitplayground.repository.PersonRepository;
import org.springframework.data.redis.support.atomic.RedisAtomicInteger;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final RedisAtomicInteger personIdCounter;
    private final PersonRepository personRepository;

    public PersonService(RedisAtomicInteger personIdCounter, PersonRepository personRepository) {
        this.personIdCounter = personIdCounter;
        this.personRepository = personRepository;
    }


    public Person createPerson(String name){
        Person person = new Person(personIdCounter.getAndIncrement(), name);
        return personRepository.save(person);
    }

    public Person findById(int id){
        return personRepository.findById(id)
                .orElseThrow();
    }

}
