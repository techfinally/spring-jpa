package com.techfinally.example.repository;

import com.techfinally.example.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tech Finally
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
