package com.crud_operation_h2.crud_operation.repository;

import com.crud_operation_h2.crud_operation.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EmployeeRepository extends JpaRepository <Employee, Long> {
}
