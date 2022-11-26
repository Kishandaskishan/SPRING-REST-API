package com.restapi.restpractice;

import java.util.List;

public interface EmployeeService21 {
    Employee21 saveEmployee(Employee21 employee21);
    List<Employee21> getAllEmployees();
    Employee21 getEmployeeById(long id);
    Employee21 updateEmployee(Employee21 employee21, long id);
    void deleteEmployee(long id);
}
