package com.learning.springboot.controller;

import com.learning.springboot.entity.Department;
import com.learning.springboot.error.DepartmentNotFoundException;
import com.learning.springboot.model.Departments;
import com.learning.springboot.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public ResponseEntity<Department> saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("Inside saveDepartment of DepartmentController");
        Department savedDepartment = departmentService.saveDepartment(department);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("/departments")
    public ResponseEntity<Departments> getDepartments() {
        List<Department> departmentList = departmentService.getDepartments();
        Departments departments = new Departments();
        departments.setDepartment(departmentList);
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @GetMapping("/departments/{departmentId}")
    public ResponseEntity<Department> getDepartment(@PathVariable Long departmentId) throws DepartmentNotFoundException {
        Department department = departmentService.getDepartment(departmentId);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @PutMapping("/departments/{departmentId}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long departmentId, @RequestBody Department department) {
        department.setDepartmentId(departmentId);
        Department updatedDepartment = departmentService.updateDepartment(department);
        return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
    }

    @DeleteMapping("/departments/{departmentId}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long departmentId) throws DepartmentNotFoundException {
        departmentService.deleteDepartment(departmentId);
        return new ResponseEntity<>("Department deleted successfully", HttpStatus.OK);
    }
}
