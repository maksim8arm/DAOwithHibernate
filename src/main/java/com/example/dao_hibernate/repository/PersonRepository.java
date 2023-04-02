package com.example.dao_hibernate.repository;

import com.example.dao_hibernate.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findAllByCityOfLiving(String cityOfLiving);

    List<Person> findAllByAgeLessThanOrderByAgeAsc(int age);

    Optional<Person> findByNameAndSurname(String name, String surname);
}

