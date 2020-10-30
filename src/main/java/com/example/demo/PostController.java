package com.example.demo;

import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/post")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Post> getPosts() {
        return postService.getPosts();
    }


    @PostMapping(value = "/post")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Post addPosts(@RequestBody Post request) {
        System.out.println(request.getContent());
        return postService.addPost(request);
    }

    @PutMapping(value = "/post")
    @ResponseStatus(code = HttpStatus.OK)
    public Post updatePosts(@RequestBody Post request) throws ChangeSetPersister.NotFoundException {
        return postService.updatePost(request);
    }

    @DeleteMapping(path = "/post/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public Post deletePosts(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return postService.deletePost(id);
    }
}
