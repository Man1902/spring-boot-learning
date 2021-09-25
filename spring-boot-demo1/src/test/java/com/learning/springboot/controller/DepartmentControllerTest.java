package com.learning.springboot.controller;

import com.learning.springboot.entity.Department;
import com.learning.springboot.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentId(1L)
                .departmentName("Test Department")
                .departmentAddress("Test Address")
                .departmentCode("Test Code")
                .build();
    }

    @Test
    public void testSaveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .departmentName("Test Department")
                .departmentAddress("Test Address")
                .departmentCode("Test Code")
                .build();
        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                "\t\"departmentName\": \"Test Department\",\n" +
                "\t\"departmentAddress\": \"Test Address\",\n" +
                "\t\"departmentCode\": \"Test Code\",\n" +
                "}"))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void testgetDepartmentById() {

    }


}