package com.asifekbal.management.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.asifekbal.management.Service.EmployeeServiceImplement;
import com.asifekbal.management.Shema.Employee;

@Controller
public class EmployeeController{

    @Autowired
    private EmployeeServiceImplement employeeServiceImplement;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        
        model.addAttribute("allemplist", employeeServiceImplement.getEmployee());
        
        return "index";
    }
    
    @GetMapping("/addnew")
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "newemployee";
    }

    @PostMapping("/save")
    public String saveEmployee(Employee employee) {
        
        employeeServiceImplement.addEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/update/{Id}")
    public String updateEmployeeById(@PathVariable(value = "Id")long Id, Model model) {
        Employee employee = employeeServiceImplement.updateEmployeeById(Id);
        model.addAttribute("employee", employee);
        return "update";
    }

    @GetMapping("/delete/{Id}")
    public String deleteEmployeeById(@PathVariable(value = "Id")long Id) {
        this.employeeServiceImplement.deleteEmployeeById(Id);
        return "redirect:/";
    }

   

}