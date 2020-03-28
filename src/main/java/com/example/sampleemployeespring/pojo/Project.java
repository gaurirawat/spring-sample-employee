package com.example.sampleemployeespring.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table
public class Project {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer project_id;

    @Column
    private String projectName;

    @Column
    private String guide;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    @JsonIgnoreProperties(value = {"project","hibernateLazyInitializer"},allowSetters = true)
    private Employee employee;

    public Project() {
    }

    public int getProject_id() {
        return project_id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setProject_id(Integer project_id) {
        this.project_id = project_id;
    }
    @Override
    public String toString() {
        return "Project{" +
                "project_id=" + project_id +
                ", projectName='" + projectName + '\'' +
                ", guide='" + guide + '\'' +
                ", employee=" + employee +
                '}';
    }

}
