package com.example.dao_hibernate;

import com.example.dao_hibernate.entity.Person;
import com.example.dao_hibernate.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootApplication
public class DaoHibernateApplication implements CommandLineRunner {
    @PersistenceContext
    EntityManager entityManager;

    public DaoHibernateApplication(PersonRepository personRepository) {

        this.personRepository = personRepository;
    }

    PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(DaoHibernateApplication.class, args);

    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {

        Person tom = new Person();
        tom.setName("Tom");
        tom.setSurname("Tomer");
        tom.setAge(44);
        tom.setCityOfLiving("Kostroma");
        tom.setPhoneNumber("1234");

        Person ivan = new Person();
        ivan.setName("Ivan");
        ivan.setSurname("Ivanov");
        ivan.setAge(34);
        ivan.setCityOfLiving("Buy");
        ivan.setPhoneNumber("1222");

        Person fedr = new Person();
        fedr.setName("Fedr");
        fedr.setSurname("Fedorov");
        fedr.setAge(64);
        fedr.setCityOfLiving("Susanino");
        fedr.setPhoneNumber("3333");

        Person roma = new Person();
        roma.setName("Roma");
        roma.setSurname("Romov");
        roma.setAge(18);
        roma.setCityOfLiving("Kostroma");
        roma.setPhoneNumber("8888");

        personRepository.save(roma);
        personRepository.save(tom);
        personRepository.save(ivan);
        personRepository.save(fedr);
        personRepository.save(roma);

    }
}
