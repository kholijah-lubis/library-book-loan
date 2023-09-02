package com.librarybl.librarybookloan.service;

import com.librarybl.librarybookloan.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployeeById(UUID id) {
        return employees.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        employee.setId(UUID.randomUUID());
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(UUID id, Employee updatedEmployee) {
        Employee existingEmployee = getEmployeeById(id);
        if (existingEmployee != null) {
            existingEmployee.setName(updatedEmployee.getName());
            existingEmployee.setPosition(updatedEmployee.getPosition());
            return existingEmployee;
        }
        return null;
    }

    @Override
    public void deleteEmployee(UUID id) {
        Employee existingEmployee = getEmployeeById(id);
        if (existingEmployee != null) {
            employees.remove(existingEmployee);
        }
    }
}
