package com.codegym.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Component
public class Form implements Validator {
    @NotEmpty
    @Size(min = 5, max = 45)
    private String firstName;

    @NotEmpty
    @Size(min = 5, max = 45)
    private String lastName;

    @Min(18)
    private int age;

    private String numberPhone;

    @Email
    private String email;


    public Form() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Form.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Form form = (Form) o;
        String formNumber = form.getNumberPhone();
        ValidationUtils.rejectIfEmpty(errors, "numberPhone", "formNumber.empty");


        if (formNumber.length() > 11 || formNumber.length() < 10) {
            errors.rejectValue("numberPhone", "formNumber.length");
        }

        if (!formNumber.startsWith("0")) {
            errors.rejectValue("numberPhone", "formNumber.startsWith");
        }
        if (!formNumber.matches("(^$|[0-9]*$)")) {
            errors.rejectValue("numberPhone", "formNumber.matches");
        }
    }
}
