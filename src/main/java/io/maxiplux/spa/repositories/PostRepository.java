package io.maxiplux.spa.repositories;



import io.maxiplux.spa.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {



}
