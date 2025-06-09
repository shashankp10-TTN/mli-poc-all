package com.poc.employeeservice.dto;

public class EmployeeRequest {
    private String name;
    private String email;
    private String password;
    private String contactNo;

    private String employeeId;
    private String competency;
    private String projectName;
    private String trackName;

    private EmployeeRequest(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.password = builder.password;
        this.contactNo = builder.contactNo;
        this.employeeId = builder.employeeId;
        this.competency = builder.competency;
        this.projectName = builder.projectName;
        this.trackName = builder.trackName;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getCompetency() {
        return competency;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getTrackName() {
        return trackName;
    }
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private String email;
        private String password;
        private String contactNo;
        private String employeeId;
        private String competency;
        private String projectName;
        private String trackName;

        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder email(String email) {
            this.email = email;
            return this;
        }
        public Builder password(String password) {
            this.password = password;
            return this;
        }
        public Builder contactNo(String contactNo) {
            this.contactNo = contactNo;
            return this;
        }
        public Builder employeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }
        public Builder competency(String competency) {
            this.competency = competency;
            return this;
        }
        public Builder projectName(String projectName) {
            this.projectName = projectName;
            return this;
        }
        public Builder trackName(String trackName) {
            this.trackName = trackName;
            return this;
        }

        public EmployeeRequest build() {
            return new EmployeeRequest(this);
        }
    }
}
