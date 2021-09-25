/*package com.learning.springboot.service;

import com.learning.springboot.entity.Department;
import com.learning.springboot.error.DepartmentNotFoundException;
import com.learning.springboot.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentId(1L)
                .departmentName("Test Department").build();
        Optional<Department> optionalDepartment = Optional.of(department);
        Mockito.when(departmentRepository.findById(1L)).thenReturn(optionalDepartment);
    }

    @Test
    //@DisplayName("Get Depatment based on valid Department Id")
    //@Disabled
    public void whenGetDepartmentByValidDepartmentId_thanReturnDepartment() throws DepartmentNotFoundException {
        Long departmentId = 1L;
        Department department = departmentService.getDepartment(departmentId);
        assertEquals(departmentId, department.getDepartmentId());
    }
}*/