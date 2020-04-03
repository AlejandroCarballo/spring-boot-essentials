package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;


@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @PostMapping
    public UUID createNewPerson(@NotNull @Valid @RequestBody Person person) {
        return personService.insertNewPerson(person);
    }

    @GetMapping(path = "{id}")
    public Person getPerson(@NotNull @PathVariable("id") UUID id) {
        return personService.getPersonById(id)
                .orElse(null);
    }


    @DeleteMapping(path = "{id}")
    public void deletePerson(@NotNull @PathVariable("id") UUID id) {
        personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void deletePerson(@NotNull @PathVariable("id") UUID id, @NotNull @Valid @RequestBody Person person) {
        personService.updatePerson(id, person);
    }
}
