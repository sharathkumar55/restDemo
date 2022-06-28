package com.example.restdemo.rest;

import com.example.restdemo.entity.Employee;
import com.example.restdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

    @RestController
    @RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService)
    {
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll()
    {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Optional<Employee> getEmployee(@PathVariable int employeeId){
        Optional<Employee> employee = employeeService.findById(employeeId);
        if(employee == null)
        {
            throw new RuntimeException("Employee ID not found"+employeeId);
        }
        return employee;

    }

    //save
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee)
    {
        //also just in case they pass an id in JSON set id to 0;
        //this is to force a save of new item ... instead of update
        theEmployee.setId(0);
        employeeService.save(theEmployee);
        return  theEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        employeeService.save(theEmployee);
        return theEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public  void deleteEmployee(@PathVariable int employeeId){
        employeeService.deleteById(employeeId);
    }
}
