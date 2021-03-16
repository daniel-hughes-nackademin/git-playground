package com.example.gitplayground.service.implementation;

import com.example.gitplayground.model.Person;
import com.example.gitplayground.repository.PersonRepository;
import com.example.gitplayground.service.PersonService;
import org.springframework.data.redis.support.atomic.RedisAtomicInteger;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    private final RedisAtomicInteger personIdCounter;
    private final PersonRepository personRepository;

    public PersonServiceImpl(RedisAtomicInteger personIdCounter, PersonRepository personRepository) {
        this.personIdCounter = personIdCounter;
        this.personRepository = personRepository;
    }


    @Override public Person createPerson(String name){
        Person person = new Person(personIdCounter.getAndIncrement(), name);
        return personRepository.save(person);
    }

    @Override public Person findById(int id){
        return personRepository.findById(id)
                .orElseThrow();
    }

}
