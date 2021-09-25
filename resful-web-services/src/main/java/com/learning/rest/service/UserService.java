package com.learning.rest.service;

import com.learning.rest.model.PostDTO;
import com.learning.rest.model.PostsDTO;
import com.learning.rest.model.UserDTO;
import com.learning.rest.model.UsersDTO;
import com.learning.rest.service.exception.UserNotFoundException;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);

    UsersDTO getAllUsers();

    UserDTO getUser(Long userId) throws UserNotFoundException;

    void editUser(UserDTO userDTO) throws UserNotFoundException;

    void deleteUser(Long userId) throws UserNotFoundException;

    PostsDTO getAllPosts(Long userId) throws UserNotFoundException;

    PostDTO createPost(Long userId, PostDTO postDTO) throws UserNotFoundException;
}
