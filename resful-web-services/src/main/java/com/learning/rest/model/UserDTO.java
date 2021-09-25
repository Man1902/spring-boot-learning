package com.learning.rest.model;

import lombok.Data;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;


@Data
public class UserDTO {
    private Long userId;

    @Size(min=3 ,message = "user name should have atleast three characters")
    private String userName;

    @Past(message = "birth date can not be future date")
    private Date dateOfBirth;
}
