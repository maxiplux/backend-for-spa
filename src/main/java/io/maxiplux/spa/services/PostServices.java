package io.maxiplux.spa.services;



import io.maxiplux.spa.models.Post;

import java.util.List;

public interface PostServices {
    List<Post> findAll();

    Post save(Post post);
}
