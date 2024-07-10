package com.onikd08.springboot.cruddemo.dao;

import com.onikd08.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    // define field for entityManager
    private EntityManager entityManager;

    // Add constructor injection
    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
        // List<Employee> employees = query.getResultList();
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        Employee employee;
        employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee employee;
        employee = entityManager.merge(theEmployee);
        return employee;
    }

    @Override
    public void deleteById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }
}
