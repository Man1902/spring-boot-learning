package com.learning.rest.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@Data
public class UsersDTO {
    private List<UserDTO> users = new ArrayList<>();
}
