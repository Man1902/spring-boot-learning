package com.learning.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learning.rest.entity.User;
import lombok.Data;

@Data
public class PostDTO {
    private Long postId;

    private String description;

    @JsonIgnore
    private User user;
}
