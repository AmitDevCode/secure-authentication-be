package com.amit.security.employee.service;

import com.amit.security.auth.request.RegisterRequest;
import com.amit.security.employee.model.Employee;
import com.amit.security.employee.model.UserActivityLog;

import java.util.List;

public interface EmployeeService {
    Employee getEmployee(String email);

    Employee updateEmployee(RegisterRequest request);

    List<Employee> getEmployees();

    List<UserActivityLog> getActivityLogs(String email);
}
