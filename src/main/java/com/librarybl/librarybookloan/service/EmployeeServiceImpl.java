package com.librarybl.librarybookloan.service;

import com.librarybl.librarybookloan.model.Employee;
import com.librarybl.librarybookloan.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(UUID id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(UUID id, Employee updatedEmployee) {
        Employee existingEmployee = employeeRepository.findById(id).orElse(null);
        if (existingEmployee != null) {
            BeanUtils.copyProperties(updatedEmployee, existingEmployee, "id");
            return employeeRepository.save(existingEmployee);
        }
        return null;
    }

    @Override
    public void deleteEmployee(UUID id) {
        Employee employeeToDelete = employeeRepository.findById(id).orElse(null);
        if (employeeToDelete != null) {
            employeeRepository.delete(employeeToDelete);
        }
    }
}
