package com.asifekbal.management.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asifekbal.management.Repo.EmployeeRepository;
import com.asifekbal.management.Shema.Employee;

@Service
public class EmployeeServiceImplement implements EmployeeServices {

    @Autowired private EmployeeRepository empRepo;

    
    @Override 
    public List<Employee> getEmployee()
    {
        return empRepo.findAll();
    }
 
    @Override 
    public void addEmployee(Employee employee)
    {
        empRepo.save(employee);
    }

 
    @Override
    public Employee updateEmployeeById(long Id) {
        Optional<Employee> optional = empRepo.findById(Id);
        Employee employee = null;
        if (optional.isPresent())
            employee = optional.get();
        else
            throw new RuntimeException(
                "Employee not found for id : " + Id);
        return employee;
   }

   @Override
   public void deleteEmployeeById(long Id) {
       this.empRepo.deleteById(Id);
   }

}
