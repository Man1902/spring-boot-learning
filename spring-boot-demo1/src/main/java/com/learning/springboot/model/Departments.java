package com.learning.springboot.model;

import com.learning.springboot.entity.Department;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Departments {
    private List<Department> department = new ArrayList<>();
}
