package com.example.sampleemployeespring.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "emp")
public class Employee {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String firstName;

    @Column
    private String LastName;

    @OneToOne(targetEntity = Cabin.class, cascade = CascadeType.ALL)
    @JoinColumn(name= "cabin_id")
    private Cabin cabin;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "employee")
    @JsonIgnoreProperties(value = {"employee", "hibernateLazyInitializer"}, allowSetters = true)
    private List<Project> projects;

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Cabin getCabin() {
        return cabin;
    }

    public void setCabin(Cabin cabin) {
        this.cabin = cabin;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
