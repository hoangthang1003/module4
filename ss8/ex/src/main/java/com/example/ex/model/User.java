package com.example.ex.model;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;
@Entity
@Table(name = "user")
public class User implements Validator {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @NotNull
    @NotBlank(message = "id.notBlank")
    private Integer id;

    @NotNull
    @NotBlank(message = "firstName.notBlank")
    private String firstName;

    @NotNull
    @NotBlank(message = "lastName.notBlank")
    private String lastName;

    @NotNull
    @NotBlank(message = "phoneNumber.notBlank")
    @Pattern(regexp = "(\\(\\d{3}\\)|\\d{3})[-\\. ]?\\d{3}[-\\. ]?\\d{4}")
    private int phoneNumber;

    @NotNull
    @NotBlank(message = "age.notBlank")
    @Min(18)
    private int age;

    @NotNull
    @NotBlank(message = "email.notBlank")
    @Email
    private String email;

    public User() {
    }

    public User(Integer id, String firstName, String lastName, int phoneNumber, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user  = (User) target;

        if ( user.firstName.length() >4 && user.firstName.length() < 46) {
            errors.rejectValue("firstName", "firstName","Độ dài của firstName phải lớn hơn 5 và bé hơn 45 kí tự");
        }
        if ( user.lastName.length() >4 && user.lastName.length() < 46) {
            errors.rejectValue("firstName", "firstName","Độ dài của firstName phải lớn hơn 5 và bé hơn 45 kí tự");
        }

    }
}
