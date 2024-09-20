package com.example.entity;

import com.example.dto.DepartmentDTO;
import com.example.dto.OrganizationDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String position;
    @Column(name = "department_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long departmentId;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "organization_id")
    private Long organizationId;

    @Transient
    private DepartmentDTO department;

    @Transient
    private OrganizationDTO organization;

    public boolean isDepartmentLess() {
        return departmentId == null;
    }

    public boolean isOrganizationLess() {
        return organizationId == null;
    }



}
