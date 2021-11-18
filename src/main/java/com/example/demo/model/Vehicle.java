package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicleId")
    private Long id;
    @Column(name = "vehicleBrand")
    private String brand;
    @Column(name = "vechicleName")
    private String name;
    @Column(name = "purchasedYear")
    private LocalDate year;
//    @Column(name = "personId")
//    private Long personId;



    @ManyToOne(optional = false)
    @JoinColumn(name = "personId",insertable = false,updatable = true,referencedColumnName = "personId")
//    @JoinColumn(name = "personId",insertable = false)
    private Person person;



    public Vehicle(Long id, String brand, String name, LocalDate year) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.year = year;
    }

    public Vehicle() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

//    public Long getPersonId() {
//        return personId;
//    }
//
//    public void setPersonId(Long personId) {
//        this.personId = personId;
//    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "Id=" + id +
                ", brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", year=" + year +
                '}';
    }
}

