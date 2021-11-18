package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping("/add")
    public Person addPerson(@RequestBody Person person)
    {
        return personService.addPerson(person);
    }

    @GetMapping("/persons")
    public List<Person> getPersons()
    {
        return personService.getPersons();
    }

    @GetMapping("person/{id}")
    public Optional<Person> getUser(@PathVariable Long id)
    {
        return personService.getUser(id);
    }

    @PutMapping("person/{id}")
    public Optional<Person> updatePerson(@RequestBody Person person,@PathVariable Long id)
    {
        return personService.updatePerson(person,id);
    }

    @DeleteMapping("person/{id}")
    public void deletePerson(@PathVariable Long id)
    {
         personService.deletePerson(id);
    }

    @GetMapping("person")
    public List<Person> getByAge(@RequestParam("age") int age)
    {
        return personService.getByAge(age);
    }

    @GetMapping("person/firstname")
    public List<Person> getByfirstname(@RequestParam("firstName") String firstName)
    {
        return personService.getByfirstname(firstName);
    }

    @GetMapping("person/lastone")
    public List<Person> getBylastname(@RequestParam("benki") String lastName)
    {
        return personService.getBylastname(lastName);
    }

    @GetMapping("person/Details")
    public List<Person> getAllDetails(@RequestParam("getDetails") String c)
    {
        return personService.getAllDetails(c);
    }

    @GetMapping("count")
    public Long totalCount()
    {
        return personService.totalCount();
    }

    @DeleteMapping("delete")
    public void delete()
    {
        personService.delete();
    }


}
