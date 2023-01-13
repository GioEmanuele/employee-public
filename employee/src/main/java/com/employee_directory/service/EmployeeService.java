package com.employee_directory.service;

import com.employee_directory.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();

    public Employee findById(int id);

    public void save(Employee employee);

    public void update(Employee employee);

    public void deleteById(int id);
}
