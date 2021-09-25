package com.learning.springboot.repository;

import com.learning.springboot.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    // @Query(" from Department where departmentName = ?1 ")                                                 // Approach1 : using JPQL
    // @Query(value = "Select * from Department_Tbl where department_Name = ?1 " , nativeQuery = true)      // Approach2 : using native SQL
    Department findByDepartmentName(String departmentName);                                                 // Approach3

    Department findByDepartmentNameIgnoreCase(String departmentName);
}
