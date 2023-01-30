package io.maxiplux.spa.controllers;


import io.maxiplux.spa.models.Post;
import io.maxiplux.spa.services.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private PostServices postServices;


    @GetMapping(value = "/")
    public ResponseEntity<?> findById() {

        List<Post> post=this.postServices.findAll();
        if (post.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Post>>(post, HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> create(@RequestBody Post postDto) {

        Post post=this.postServices.save(postDto);
        if (post.getId() == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Post>(post, HttpStatus.OK);
    }

    @GetMapping("/who-am-i")
    public String getUsers(HttpServletRequest request) {
        return request.getUserPrincipal().getName();
    }
}
