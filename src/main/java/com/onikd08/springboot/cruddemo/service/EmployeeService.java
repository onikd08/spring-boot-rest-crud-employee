package com.onikd08.springboot.cruddemo.service;

import com.onikd08.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
}
