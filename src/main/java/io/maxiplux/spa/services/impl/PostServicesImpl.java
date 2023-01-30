package io.maxiplux.spa.services.impl;


import io.maxiplux.spa.models.Post;
import io.maxiplux.spa.repositories.PostRepository;
import io.maxiplux.spa.services.PostServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostServicesImpl implements PostServices {
    private final PostRepository postRepository;
    @Override
    public List<Post> findAll() {
        return (List<Post>) this.postRepository.findAll();
    }

    @Override
    public Post save(Post post) {
        return this.postRepository.save(post);
    }
}
