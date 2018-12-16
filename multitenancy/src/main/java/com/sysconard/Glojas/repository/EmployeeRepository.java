package com.sysconard.Glojas.repository;

import org.springframework.data.repository.CrudRepository;

import com.sysconard.Glojas.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
