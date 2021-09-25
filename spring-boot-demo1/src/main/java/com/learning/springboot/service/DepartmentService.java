package com.learning.springboot.service;

import com.learning.springboot.entity.Department;
import com.learning.springboot.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> getDepartments();

    Department getDepartment(Long departmentId) throws DepartmentNotFoundException;

    Department updateDepartment(Department department);

    void deleteDepartment(Long departmentId) throws DepartmentNotFoundException;
}
