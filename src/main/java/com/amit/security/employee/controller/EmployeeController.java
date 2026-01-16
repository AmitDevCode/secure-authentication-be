package com.amit.security.employee.controller;

import com.amit.security.employee.model.UserActivityLog;
import com.amit.security.employee.service.EmployeeService;
import com.amit.security.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(value = "*")
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/activityLog")
    public ResponseEntity<List<UserActivityLog>> getUserActivityLogs(@RequestParam String email) {
        return ResponseEntity.ok(employeeService.getActivityLogs(email));
    }
}
