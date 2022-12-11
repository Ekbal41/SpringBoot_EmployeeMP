package com.asifekbal.management.Service;

import java.util.List;

import com.asifekbal.management.Shema.Employee;

public interface EmployeeServices {
    public List<Employee> getEmployee();
    Employee updateEmployeeById(long Id);
    void addEmployee(Employee employee);
    void deleteEmployeeById(long Id);
    
    
    
}
