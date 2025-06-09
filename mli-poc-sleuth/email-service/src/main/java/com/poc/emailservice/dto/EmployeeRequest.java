package com.poc.emailservice.dto;

public class EmployeeRequest {
    private String name;
    private String email;
    private String password;
    private String contactNo;

    private String employeeId;
    private String competency;
    private String projectName;

    public EmployeeRequest() {}

    public EmployeeRequest(String name, String email, String password, String contactNo, String employeeId, String competency, String projectName, String trackName) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.contactNo = contactNo;
        this.employeeId = employeeId;
        this.competency = competency;
        this.projectName = projectName;
        this.trackName = trackName;
    }

    private String trackName;

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
}
