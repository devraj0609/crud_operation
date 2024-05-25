package com.crud_operation_h2.crud_operation.service;

import com.crud_operation_h2.crud_operation.model.Employee;
import com.crud_operation_h2.crud_operation.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository empRepo;
    public List<Employee> getAllEmployee() {
        return empRepo.findAll();

    }

    public Optional<Employee> getEmployeeById(Long empId) {
        return  empRepo.findById(empId);
    }

    public Employee createEmployee(Employee emp) {
        return empRepo.save(emp);
    }


    public Employee updateEmployee(Long empId, Employee empdata) throws Exception {
        Employee employee = empRepo.findById(empId)
                 .orElseThrow(() -> new Exception("No details found for this employee id"));
                 employee.setEmail(empdata.getEmail());
                 employee.setFirst_Name(empdata.getFirst_Name());
                 employee.setLast_Name(empdata.getLast_Name());
                 employee.setGender(empdata.getGender());
                 employee.setId(empdata.getId());
                 return  empRepo.save(employee);
    }


    public void deleteEmployee(Long empId) throws Exception {
        Employee employee = empRepo.findById(empId)
                .orElseThrow(() -> new Exception("No details found for this employee id"));
                empRepo.delete(employee);

    }
}
