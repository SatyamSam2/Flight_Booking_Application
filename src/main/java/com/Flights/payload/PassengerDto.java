package com.Flights.payload;

import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class PassengerDto {

    @Size(min = 2, message = "firstName should be more than 2 characters")
    private String firstName;

    @Size(min = 2, message = "lastName should be more than 2 characters")
    private String lastName;

    private String middleName;

    @Size(min = 6, message = "email should be at least 6 characters long")
    @Email(message = "email should be a valid email address")
    private String email;

    @Pattern(regexp = "^(\\+[0-9]{1,3}[- ]?)?\\(?[0-9]{3}\\)?[- ]?[0-9]{3}[- ]?[0-9]{4}$", message = "Phone number should be in a valid format")
    private String phone;
}
