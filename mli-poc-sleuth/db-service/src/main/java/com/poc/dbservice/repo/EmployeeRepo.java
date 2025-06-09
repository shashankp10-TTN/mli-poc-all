package com.poc.dbservice.repo;

import com.poc.dbservice.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepo extends MongoRepository<Employee,String> {
}
