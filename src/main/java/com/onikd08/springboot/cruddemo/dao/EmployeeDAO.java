package com.onikd08.springboot.cruddemo.dao;

import com.onikd08.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
