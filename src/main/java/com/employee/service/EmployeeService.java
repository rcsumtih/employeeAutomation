package com.employee.service;

import com.employee.entity.Jobs;
import com.employee.entity.User;
import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repo;
    public void createEmployee(User user)
    {
        Employee emp=new Employee();
        emp.setId(user.getUserId());
        emp.setEmail(user.getEmail());
        emp.setFirstName(user.getFirstName());
        emp.setLastName(user.getLastName());
        repo.save(emp);
    }
    public List<Employee> employeeDetails()
    {
        return repo.findAll();
    }
    public Optional<Employee> fetchEmployee(int employeeId)
    {
        Optional<Employee> tempEmployee = repo.findById(employeeId);
        return tempEmployee;
    }

    public void deleteEmployee(int id) {
        repo.deleteById(id);
    }
}
