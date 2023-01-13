package com.employee_directory.controller;

import com.employee_directory.entity.Employee;
import com.employee_directory.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mvc")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/show-list-employee")
    public String getEmployees(Model theModel) {
        List<Employee> listEmployee = employeeService.findAll();
        theModel.addAttribute("employees", listEmployee);
        return "employee-list";
    }

    @GetMapping("/show-list-employee-update-button")
    public String getEmployeesUpdateButton(Model theModel) {
        List<Employee> listEmployee = employeeService.findAll();
        theModel.addAttribute("employees", listEmployee);
        return "employee-list-update-button";
    }

    @GetMapping("/update-employee-form")
    public String showFormForUpdate(@RequestParam("employeeId") int id, Model model) {
        Employee theEmployee = employeeService.findById(id);
        model.addAttribute("employee", theEmployee);
        return "update-form";
    }

    @GetMapping("/add-employee-form")
    public String addEmployee(Model theModel) {
        Employee theEmployee = new Employee();
        theModel.addAttribute("employee", theEmployee);
        return "update-form";
    }

    @GetMapping("/show-list-employee-delete-button")
    public String showDeleteForm(Model theModel) {
        List<Employee> listEmployee = employeeService.findAll();
        theModel.addAttribute("employees", listEmployee);
        return "employee-list-delete-button";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Employee employee) {
        employeeService.save(employee);
        return "redirect:/mvc/show-list-employee";
    }


    @GetMapping ("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int id) {
        employeeService.deleteById(id);
        return "redirect:/mvc/show-list-employee";
    }

}
