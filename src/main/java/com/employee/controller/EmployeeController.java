package com.employee.controller;
import com.employee.entity.User;
import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController           
public class EmployeeController {

    @Autowired
   private EmployeeService service;

    @PostMapping(value="/append")
    public void create(@RequestBody User user)
    {
        service.createEmployee(user);
    }

    @DeleteMapping(value="/delete")
      public void delete(int id)
    {

        service.deleteEmployee(id);
    }

    @GetMapping(value="/EmployeeDetail")
    public ResponseEntity<List<Employee>> display()
    {
        return new ResponseEntity<>(service.employeeDetails(), HttpStatus.valueOf(200));
    }

    @GetMapping(value="/EmployeeDetails/{id}")
    public  ResponseEntity<Employee>fetchDetail(@PathVariable int id)
    {
        Optional<Employee> emp = service.fetchEmployee(id);
        if(emp.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
         else
            return new ResponseEntity<>(emp.get(),HttpStatus.OK);
    }

}
