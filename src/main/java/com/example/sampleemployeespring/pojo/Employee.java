package com.example.sampleemployeespring.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Employee {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @OneToOne(mappedBy ="employee", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = {"employee", "hibernateLazyInitializer"}, allowSetters = true)
    private Cabin cabin;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "employee")
    @JsonIgnoreProperties(value = {"employee", "hibernateLazyInitializer"}, allowSetters = true)
    private List<Project> projects;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name="dept_id")
    @JsonIgnoreProperties(value = {"employees", "hibernateLazyInitializer"}, allowSetters = true)
   // @Nullable
    private Department department;

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + name + '\'' +
                ", cabin=" + cabin +
                ", projects=" + projects +
                ", department=" + department +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
