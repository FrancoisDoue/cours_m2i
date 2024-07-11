package com.example.ex9_employee_back.dto;

import com.example.ex9_employee_back.entity.Person;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
public abstract class PersonGetDTO<T extends Person> {
    protected int id;
    protected String firstname;
    protected String lastname;
    protected String identificationNumber;
    protected String address;
    protected String phone;
    protected String email;
    protected String birthDate;
    protected String observation;

    public PersonGetDTO(T entity) {
        this.id = entity.getId();
        this.firstname = entity.getFirstname();
        this.lastname = entity.getLastname();
        this.identificationNumber = entity.getIdentificationNumber();
        this.address = entity.getAddress();
        this.phone = entity.getPhone();
        this.email = entity.getEmail();
        this.birthDate = entity.getBirthDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.observation = entity.getObservation();
    }
}
