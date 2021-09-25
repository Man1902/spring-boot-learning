package com.learning.springboot.repository;

import com.learning.springboot.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("Test Department")
                .departmentAddress("Test Address")
                .departmentCode("Test code")
                .build();
        testEntityManager.persist(department);
    }

    @Test
    public void whenFindById_thanReturnDepartment() {
        Department department = departmentRepository.findById(1L).get();
        assertEquals("Test Department", department.getDepartmentName());
    }
}