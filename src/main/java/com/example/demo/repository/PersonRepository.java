package com.example.demo.repository;

import com.example.demo.model.Person;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonRepository extends CrudRepository<Person,Long> {
//    public List<Person> findByAge(int age);
    public List<Person> findByFirstName(String firstName);
    List<Person> findByLastName(String lastName);
}
