package com.example.ex.dto;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
public class UserDTO implements Validator {
    @NotBlank(message = "can't be empty")
    @Size(min = 5,max = 45,message = "Input more than 5 characters and less than 45 characters")
    private String firstName;
    @NotBlank(message = "can't be empty")
    @Size(min = 5,max = 45,message = "Input more than 5 characters and less than 45 characters")
    private String lastName;
    @Pattern(regexp = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$",message = "Incorrect phone number syntax")
    @NotBlank(message = "can't be empty")
    private String phoneNumber;
    @NotBlank(message = "can't be empty")
    @Pattern(regexp = "^(18|19|)|([2-9][0-9])$",message = "age must be over 18")
    private String age;
    @NotBlank(message = "can't be empty")
    @Email(message = "Incorrect syntax")
    private String email;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
    }

    public UserDTO() {
    }

    public UserDTO(String firstName, String lastName, String phoneNumber, String age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
