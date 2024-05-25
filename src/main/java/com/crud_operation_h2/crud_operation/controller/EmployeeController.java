package com.crud_operation_h2.crud_operation.controller;

import com.crud_operation_h2.crud_operation.model.Employee;
import com.crud_operation_h2.crud_operation.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/demo")
public class EmployeeController {

    @Autowired
    private EmployeeService empService;
    @GetMapping("/employee")
    public List<Employee> getAllEmployee() {
        return  empService.getAllEmployee();

    }
    @GetMapping("/employee/{id}")   // using path-variable here through id
    public ResponseEntity<Optional<Employee> > getEmployeeById(@PathVariable(value = "id") Long empId) {
            return ResponseEntity.ok(empService.getEmployeeById(empId));
    }

    @PostMapping("/employee")
    private Employee createEmployee(@RequestBody Employee emp) {
        return empService.createEmployee(emp);
    }

    @PutMapping("/employee/{id}")
    private ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long empId, @RequestBody Employee empdata) throws Exception {
        return  ResponseEntity.ok(empService.updateEmployee(empId, empdata));
    }

    @DeleteMapping("/employee/{id}")
    private Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long empId) throws Exception {
         empService.deleteEmployee(empId);
         Map<String, Boolean>  result=  new HashMap<>();
         result.put("Delete", true);
         return result;
    }
}
