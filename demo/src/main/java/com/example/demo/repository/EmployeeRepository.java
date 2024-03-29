package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
	List<Employee> findByStatusTrue(); // Retrieve records with status=true

    void deleteByEmpid(Long empid); // Soft delete by setting status to false

}
