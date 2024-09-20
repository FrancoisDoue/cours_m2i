package com.example.entity;

import com.example.dto.EmployeeDTO;
import com.example.dto.OrganizationDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Department {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "organization_id")
    private Long organizationId;

    @Transient
    private OrganizationDTO organization;

    @Transient
    private List<EmployeeDTO> employees;

    public boolean isOrganizationLess() {
        return organizationId == null;
    }


}
