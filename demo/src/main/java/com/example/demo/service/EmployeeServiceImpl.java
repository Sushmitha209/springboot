package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	 @Autowired
	 private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> fetchAllEmployees() {
		return employeeRepository.findByStatusTrue();
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).orElse(null);
	}

	@Override
	public Employee updateEmployeeById(Long id, Employee updatedEmployee) {
	    Employee existingEmployee = employeeRepository.findById(id).orElse(null);

	    if (existingEmployee != null) {
	        // Update non-null properties from updatedEmployee to existingEmployee
	        if (updatedEmployee.getEmpName() != null) {
	            existingEmployee.setEmpName(updatedEmployee.getEmpName());
	        }
	        if (updatedEmployee.getEmpAddress() != null) {
	            existingEmployee.setEmpAddress(updatedEmployee.getEmpAddress());
	        }
	        if (updatedEmployee.getEmpRole() != null) {
	            existingEmployee.setEmpRole(updatedEmployee.getEmpRole());
	        }

	        // Save the updated employee
	        return employeeRepository.save(existingEmployee);
	    }

	    return null; // Return null if the employee with the given id is not found
	}



	@Override
	public void deleteDepartmentById(long id) {
		 Employee employee = employeeRepository.findById(id).orElse(null);
	        if (employee != null) {
	            // Soft delete by setting status to false
	            employee.setStatus(false);
	            employeeRepository.save(employee);
	        }
	}





}
