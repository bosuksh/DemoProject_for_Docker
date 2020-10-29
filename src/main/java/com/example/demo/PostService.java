package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public Post addPost(Post newPost) {
        return postRepository.save(newPost);
    }


    public Post updatePost(Post updatedPost) throws ChangeSetPersister.NotFoundException {
        Post existedPost = postRepository.findById(updatedPost.getId()).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        existedPost.setContent(updatedPost.getContent());
        return postRepository.save(existedPost);
    }

    public Post deletePost(Long id) throws ChangeSetPersister.NotFoundException {
        Post post = postRepository.findById(id).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        postRepository.deleteById(id);
        return post;
    }
}
