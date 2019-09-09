package com.techfinally.example.controller;

import com.techfinally.example.bean.ResponseData;
import com.techfinally.example.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.techfinally.example.repository.EmployeeRepository;

/**
 *
 * @author PALT190
 */
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping(consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData> findByAll() {
        ResponseData response = new ResponseData();
        response.setCode(200);
        response.setData(employeeRepository.findAll());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData> findById(@PathVariable(value = "id") String id) {
        ResponseData response = new ResponseData();
        response.setCode(200);
        response.setData(employeeRepository.findById(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData> create(@RequestBody Employee employee) {
        employee = employeeRepository.save(employee);
        employeeRepository.flush();
        ResponseData response = new ResponseData();
        response.setCode(200);
        response.setData(employee);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData> update(@RequestBody Employee employee) {
        employee = employeeRepository.save(employee);
        employeeRepository.flush();
        ResponseData response = new ResponseData();
        response.setCode(200);
        response.setData("ok");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData> delete(@PathVariable String id) {
        employeeRepository.delete(employeeRepository.findById(id).get());
        ResponseData response = new ResponseData();
        response.setCode(200);
        response.setData("ok");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
