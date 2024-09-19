package com.example.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String position;
    private Long departmentId;
    private Long organizationId;
    @Transient
    private boolean isOrganizationLess = (organizationId == null || organizationId.equals(0L));
    @Transient
    private boolean isDepartmentLess = (departmentId == null || departmentId.equals(0L));

}
