package com.restapi.restpractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController21 {
    private EmployeeService21 employeeService;

    @Autowired
    public EmployeeController21(EmployeeService21 employeeService) {
        this.employeeService = employeeService;
    }

    //create employees REST API
    @PostMapping
    public ResponseEntity<Employee21> saveEmployee(@RequestBody Employee21 employee21){
        return new ResponseEntity<Employee21>(employeeService.saveEmployee(employee21), HttpStatus.CREATED);
    }

    //code get all employees REST API
    @GetMapping
    public List<Employee21> getAllEmployees(){
        return  employeeService.getAllEmployees();

    }

    //Build  get employee by ID REST API
    @GetMapping("{id}")
    public ResponseEntity<Employee21> getEmployeeById(@PathVariable("id") long employeeId){
        return new ResponseEntity<Employee21>(employeeService.getEmployeeById(employeeId),HttpStatus.OK);
    }

    //Build UpdateEmployee REST API
    @PutMapping("{id}")
    public ResponseEntity<Employee21> updateEmployee(@PathVariable("id") long id,
                                                     @RequestBody Employee21 employee21){
        return new ResponseEntity<Employee21>(employeeService.updateEmployee(employee21,id),HttpStatus.OK);

    }

//Build delete employee REST API
    @DeleteMapping("{id}")
public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee deleted Successfully !",HttpStatus.OK);
    }





}
