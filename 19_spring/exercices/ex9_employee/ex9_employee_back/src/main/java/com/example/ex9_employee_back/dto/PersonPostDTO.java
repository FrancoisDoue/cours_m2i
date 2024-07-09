package com.example.ex9_employee_back.dto;

import com.example.ex9_employee_back.entity.Person;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public abstract class PersonPostDTO<T extends Person> {

    protected String firstname;
    protected String lastname;
    protected String identificationNumber;
    protected String address;
    protected String phone;
    protected String email;
    protected String birthDate;
    protected String observation;

    public abstract T toEntity();
}
