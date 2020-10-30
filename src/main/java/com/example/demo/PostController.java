package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping()
    @ResponseStatus(code = HttpStatus.OK)
    public List<Post> getPosts() {
        return postService.getPosts();
    }

    @CrossOrigin
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public Post addPosts(@RequestBody Post request) {
        return postService.addPost(request);
    }

    @PutMapping()
    @ResponseStatus(code = HttpStatus.OK)
    public Post updatePosts(@RequestBody Post request) throws ChangeSetPersister.NotFoundException {
        return postService.updatePost(request);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public Post deletePosts(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return postService.deletePost(id);
    }
}
