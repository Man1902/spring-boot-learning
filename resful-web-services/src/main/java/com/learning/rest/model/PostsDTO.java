package com.learning.rest.model;

import lombok.Data;

@Data
public class PostDTO {
    private Long postId;

    private String description;

    private Long userId;
}
