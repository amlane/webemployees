package com.amlane.webemployees;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
// Beans - POJOs managed by Spring
@RequestMapping("/data")
public class EmployeeController
{
    // localhost:2019/data/allemployees
    @GetMapping(value = "/allemployees",
                produces = {"application/json"})
    public ResponseEntity<?> getAllEmployees()
    {
        WebEmployeesApplication.ourEmpList.empList.sort((e1, e2) -> e1.getFname()
                .compareToIgnoreCase(e2.getFname()));
        return new ResponseEntity<>(WebEmployeesApplication.ourEmpList.empList,
                HttpStatus.OK);
    }
    // localhost:2019/data/employee/2
    // WebEmployeesApplication.ourEmpList.findEmployee(e -> (e.getId() == empID))
    @GetMapping(value = "/employee/{empID}", produces = {"application/json"})
    public ResponseEntity<?> getEmployeeById(@PathVariable long empID)
    {
        return new ResponseEntity<>(WebEmployeesApplication.ourEmpList.findEmployee(e -> (e.getId() == empID)), HttpStatus.OK);
    }

    // localhost:2019/data/employees/s
    @GetMapping(value = "/employees/{letter}", produces = {"application/json"})
    public ResponseEntity<?> getEmployeesByFname(@PathVariable char letter)
    {
        ArrayList<Employee> rtnEmps = WebEmployeesApplication.ourEmpList.findEmployees(e -> e.getFname().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        rtnEmps.sort((e1, e2) -> e1.getFname().compareToIgnoreCase(e2.getFname()));
        return new ResponseEntity<>(rtnEmps, HttpStatus.OK);
    }


}