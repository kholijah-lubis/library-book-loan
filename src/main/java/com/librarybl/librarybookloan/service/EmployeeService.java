package com.librarybl.librarybookloan.service;

import com.librarybl.librarybookloan.model.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(UUID id);
    Employee createEmployee(Employee employee);
    Employee updateEmployee(UUID id, Employee updatedEmployee);
    void deleteEmployee(UUID id);
}
