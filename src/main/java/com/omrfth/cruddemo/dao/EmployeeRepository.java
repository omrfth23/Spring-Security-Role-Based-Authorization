package com.omrfth.cruddemo.dao;

import com.omrfth.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "employee")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
