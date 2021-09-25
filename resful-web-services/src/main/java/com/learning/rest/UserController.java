package com.learning.rest;

import com.learning.rest.model.PostDTO;
import com.learning.rest.model.PostsDTO;
import com.learning.rest.model.UserDTO;
import com.learning.rest.model.UsersDTO;
import com.learning.rest.service.UserService;
import com.learning.rest.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody UserDTO userDTO) {
        UserDTO savedUserDTO = userService.createUser(userDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userId}").buildAndExpand(savedUserDTO.getUserId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping(value = "/users")
    public ResponseEntity<UsersDTO> getAllUsers() {
        UsersDTO usersDTO = userService.getAllUsers();
        return new ResponseEntity<>(usersDTO, HttpStatus.OK);
    }

    // Note with HATEOAS implementation
    @GetMapping("/users/{userId}")
    public EntityModel<UserDTO> getUser(@PathVariable Long userId) throws UserNotFoundException {
        UserDTO userDTO = userService.getUser(userId);

        EntityModel<UserDTO> entityModel = EntityModel.of(userDTO);

        WebMvcLinkBuilder linkToUsers = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers());
        entityModel.add(linkToUsers.withRel("all-users"));

        return entityModel;
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<String> editUser(@PathVariable Long userId, @RequestBody UserDTO userDTO) throws UserNotFoundException {
        userDTO.setUserId(userId);
        userService.editUser(userDTO);
        return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) throws UserNotFoundException {
        userService.deleteUser(userId);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/posts")
    public ResponseEntity<PostsDTO> getAllPosts(@PathVariable Long userId) throws UserNotFoundException {
        PostsDTO postsDTO =  userService.getAllPosts(userId);
        return new ResponseEntity<>(postsDTO, HttpStatus.OK);
    }

    @PostMapping("/users/{userId}/posts")
    public ResponseEntity<Object> createPost(@PathVariable Long userId , @RequestBody PostDTO postDTO) throws UserNotFoundException {
        PostDTO savedPostDTO = userService.createPost(userId, postDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{postId}").buildAndExpand(savedPostDTO.getPostId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
