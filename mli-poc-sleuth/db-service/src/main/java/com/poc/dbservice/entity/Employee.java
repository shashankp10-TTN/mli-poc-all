package com.poc.dbservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employee")
public class Employee {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private String contactNo;

    private String employeeId;
    private String competency;
    private String projectName;
    private String trackName;

    public Employee(){}

    public Employee(String id, String name, String email, String password, String contactNo, String employeeId, String competency, String projectName, String trackName) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.contactNo = contactNo;
        this.employeeId = employeeId;
        this.competency = competency;
        this.projectName = projectName;
        this.trackName = trackName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getCompetency() {
        return competency;
    }

    public void setCompetency(String competency) {
        this.competency = competency;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", competency='" + competency + '\'' +
                ", projectName='" + projectName + '\'' +
                ", trackName='" + trackName + '\'' +
                '}';
    }
}
