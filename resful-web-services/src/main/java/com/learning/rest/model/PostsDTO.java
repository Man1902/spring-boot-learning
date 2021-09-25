package com.learning.rest.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PostsDTO {
    private List<PostDTO> posts = new ArrayList<>();
}
