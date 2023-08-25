package com.lib.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lib.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
