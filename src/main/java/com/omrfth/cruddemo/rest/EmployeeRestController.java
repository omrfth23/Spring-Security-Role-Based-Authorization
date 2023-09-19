package com.omrfth.cruddemo.rest;

import com.omrfth.cruddemo.dao.EmployeeDAO;
import com.omrfth.cruddemo.entity.Employee;
import com.omrfth.cruddemo.service.EmployeeService;
import com.omrfth.cruddemo.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId){
      Employee theEmployee = employeeService.findById(employeeId);

      if(theEmployee == null){
          throw new RuntimeException("Employee Not Found --" + employeeId);
      }
      return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){

        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee tempEmployee = employeeService.findById(employeeId);
        if(tempEmployee == null){
            throw new RuntimeException("Employee Not Found " + employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Deleted employee Employee ID : " + employeeId;
    }
}
