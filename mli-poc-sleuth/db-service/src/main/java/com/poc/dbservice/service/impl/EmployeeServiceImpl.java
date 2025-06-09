package com.poc.dbservice.service.impl;

import com.poc.dbservice.dto.EmployeeRequest;
import com.poc.dbservice.entity.Employee;
import com.poc.dbservice.repo.EmployeeRepo;
import com.poc.dbservice.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;

    public  EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public void saveEmployee(EmployeeRequest employeeRequest) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeRequest, employee);
        Employee savedEmployee = employeeRepo.save(employee);
        System.out.println(savedEmployee.toString());
    }
}
