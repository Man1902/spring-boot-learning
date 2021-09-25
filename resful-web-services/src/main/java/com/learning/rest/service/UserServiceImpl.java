package com.learning.rest.service;

import com.learning.rest.entity.Post;
import com.learning.rest.entity.User;
import com.learning.rest.model.PostDTO;
import com.learning.rest.model.PostsDTO;
import com.learning.rest.model.UserDTO;
import com.learning.rest.model.UsersDTO;
import com.learning.rest.repository.PostRepository;
import com.learning.rest.repository.UserRepository;
import com.learning.rest.service.exception.UserNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);

        user = userRepository.save(user);
        userDTO.setUserId(user.getUserId());
        return userDTO;
    }

    @Override
    public UsersDTO getAllUsers() {
        List<User> listUsers = userRepository.findAll();
        UsersDTO usersDTO = new UsersDTO();
        if (!listUsers.isEmpty()) {
            List<UserDTO> listUserDTOs = listUsers.stream()
                    .map(user -> {
                        UserDTO userDTO = new UserDTO();
                        BeanUtils.copyProperties(user, userDTO);
                        return userDTO;
                    })
                    .collect(Collectors.toList());
            usersDTO.setUsers(listUserDTOs);
        }
        return usersDTO;
    }

    @Override
    public UserDTO getUser(Long userId) throws UserNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("user not found"));
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

    @Override
    public void editUser(UserDTO userDTO) throws UserNotFoundException {
        userRepository.findById(userDTO.getUserId()).orElseThrow(() -> new UserNotFoundException("user not found"));
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) throws UserNotFoundException {
        userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("user not found"));
        userRepository.deleteById(userId);
    }

    @Override
    public PostsDTO getAllPosts(Long userId) throws UserNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("user not found"));
        PostsDTO postsDTO = new PostsDTO();
        if (!user.getPosts().isEmpty()) {
            List<PostDTO> posts = user.getPosts().stream()
                    .map(post -> {
                        PostDTO postDTO = new PostDTO();
                        /*postDTO.setPostId(post.getPostId());
                        postDTO.setDescription(post.getDescription());*/
                        BeanUtils.copyProperties(post, postDTO);
                        return postDTO;
                    })
                    .collect(Collectors.toList());
            postsDTO.setPosts(posts);
        }
        return postsDTO;
    }

    @Override
    public PostDTO createPost(Long userId, PostDTO postDTO) throws UserNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("user not found"));

        Post post = new Post();
        BeanUtils.copyProperties(postDTO, post);
        post.setUser(user);

        post = postRepository.save(post);
        postDTO.setPostId(post.getPostId());
        return postDTO;
    }
}
