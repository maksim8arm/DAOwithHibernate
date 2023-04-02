package com.example.dao_hibernate.controller;

import com.example.dao_hibernate.entity.Person;
import com.example.dao_hibernate.repository.PersonRepository;
import com.example.dao_hibernate.repository.RepositoryPerson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    private final RepositoryPerson repositoryPerson;
    private final PersonRepository personRepository;

    public Controller(RepositoryPerson repositoryPerson, PersonRepository personRepository) {
        this.repositoryPerson = repositoryPerson;
        this.personRepository = personRepository;
    }

    @GetMapping("/products/fetch-product")
    @ResponseBody
    public List getUserName(@RequestParam("city") String city) {
        return repositoryPerson.getPersonsByCity(city);
    }

    @GetMapping("/fcity")
    @ResponseBody
    public List<Person> getCity(@RequestParam("city") String city) {

        return personRepository.findAllByCityOfLiving(city);
    }

    @GetMapping("/fage")
    @ResponseBody
    public List<Person> getAge(@RequestParam("age") int age) {

        return personRepository.findAllByAgeLessThanOrderByAgeAsc(age);
    }

    @GetMapping("/fnamesur")
    @ResponseBody
    public Optional<Person> getNameAndSurname(@RequestParam("name") String name,
                                              @RequestParam("surname") String surname) {
        return personRepository.findByNameAndSurname(name, surname);
    }

}
