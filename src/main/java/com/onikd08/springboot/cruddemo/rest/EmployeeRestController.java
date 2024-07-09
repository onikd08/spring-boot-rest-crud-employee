package com.onikd08.springboot.cruddemo.rest;

import com.onikd08.springboot.cruddemo.dao.EmployeeDAO;
import com.onikd08.springboot.cruddemo.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    // inject employee dao
    private EmployeeDAO employeeDAO;

    // constructor injection
    public EmployeeRestController(EmployeeDAO theEmployeeDAO) {
        employeeDAO = theEmployeeDAO;
    }

    // expose "/employees" to return all employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeDAO.findAll();
    }
}
