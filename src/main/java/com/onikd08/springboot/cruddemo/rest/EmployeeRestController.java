package com.onikd08.springboot.cruddemo.rest;

import com.onikd08.springboot.cruddemo.entity.Employee;
import com.onikd08.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    EmployeeService employeeService;
    // constructor injection
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    // expose "/employees" to return all employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.findAll();
    }

    // expose "/employees/{employeeId}" to return employee with id
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId){

        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null) {
            throw new RuntimeException("Employee with id " + employeeId + " not found");
        }
        return theEmployee;
    }

    // Post map "/employees" to save employees
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee theEmployee){

        // in case someone put id in the json body by mistake,
        // force the id to set to 0 so that it saves a new item instead of an update
        theEmployee.setId(0);
        Employee newEmployee;
        newEmployee = employeeService.save(theEmployee);
        return newEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){

        Employee newEmployee;
        newEmployee = employeeService.save(theEmployee);
        return newEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee theEmployee;
        theEmployee = employeeService.findById(employeeId);
        if (theEmployee == null){
            throw new RuntimeException("Employee with id " + employeeId + " not found");
        }
        employeeService.deleteById(employeeId);
        return "Employee with id " + employeeId + " deleted";
    }




}
