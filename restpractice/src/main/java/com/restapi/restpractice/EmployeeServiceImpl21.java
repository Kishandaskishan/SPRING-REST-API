package com.restapi.restpractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl21 implements EmployeeService21 {
    private EmployeeRepository21 employeeRepository21;

    @Autowired
    public EmployeeServiceImpl21(EmployeeRepository21 employeeRepository21) {
        this.employeeRepository21 = employeeRepository21;
    }

    @Override
    public Employee21 saveEmployee(Employee21 employee21) {
        return employeeRepository21.save(employee21);
    }

    @Override
    public List<Employee21> getAllEmployees() {
        return  employeeRepository21.findAll();
    }

    @Override
    public Employee21 getEmployeeById(long id) {
       Optional<Employee21> employee= employeeRepository21.findById(id);
        /*if (employee.isPresent()){
            return employee.get();
        }else {
            throw new ResourceNotFoundException("Employee", "id", id);
        }*/
    return employeeRepository21.findById(id).orElseThrow(()->
          new ResourceNotFoundException21("Employee","id",id));
    }

    @Override
    public Employee21 updateEmployee(Employee21 employee21, long id) {
        //Check if the employee exists in the database
        Employee21 existingEmployee21 = employeeRepository21.findById(id).orElseThrow(
                ()->new ResourceNotFoundException21("Employee","Id",id));

        existingEmployee21.setFirstName(employee21.getFirstName());
        existingEmployee21.setLastName(employee21.getLastName());
        existingEmployee21.setEmail(employee21.getEmail());
        employeeRepository21.save(existingEmployee21);

        return existingEmployee21;
    }

    @Override
    public void deleteEmployee(long id) {
        //check whether employee exist in the database or not
        employeeRepository21.findById(id).orElseThrow(
                ()->new ResourceNotFoundException21("Employee","id",id));

        employeeRepository21.deleteById(id);
    }
}
