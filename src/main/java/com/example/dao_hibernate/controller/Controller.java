package com.example.dao_hibernate.controller;

import com.example.dao_hibernate.repository.PersonRepository;
import com.example.dao_hibernate.repository.RepositoryPerson;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
public class Controller {

    private final RepositoryPerson repositoryPerson;
    private final PersonRepository personRepository;

    public Controller(RepositoryPerson repositoryPerson, PersonRepository personRepository) {
        this.repositoryPerson = repositoryPerson;
        this.personRepository = personRepository;
    }

    @Secured({"ROLE_READ"})
    @GetMapping("/read")
    public String read() {
        return "READ";
    }

    @RolesAllowed({"ROLE_WRITE"})
    @GetMapping("/write")
    public String write() {
        return "WRITE";
    }

    @PreAuthorize("hasRole('WRITE') or hasRole('DELETE')")
    @GetMapping("/delete")
    public String delete() {
        return "DELETE";
    }

    @PostAuthorize("hasRole('WRITE') or hasRole('DELETE')")
    @GetMapping("/write2")
    public String write2() {
        return "WRITE2";
    }

    @PreAuthorize("principal.username == #name")
    @GetMapping("/name")
    public String name(@Param("name") String name) {
        return name;
    }
}
