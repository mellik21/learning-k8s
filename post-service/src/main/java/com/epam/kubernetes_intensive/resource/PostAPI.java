package com.epam.kubernetes_intensive.resource;

import com.epam.kubernetes_intensive.model.Post;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/posts")
public interface PostAPI {

    @GetMapping("/{id}")
    @ApiOperation(value = "Get post by ID")
    Post getPostById(@PathVariable Long id);

    @GetMapping("/")
    @ApiOperation(value = "Get all posts")
    List<Post> getAllPosts();

    @PostMapping("/")
    @ApiOperation(value = "Create post")
    @ApiParam(
            name = "post",
            type = "com.epam.kubernetes_intensive.model.Post",
            example = "{\n" +
                    "    \"id\": 3,\n" +
                    "    \"content\": \"Third post\",\n" +
                    "    \"userId\": 1\n" +
                    "}"
    )
    void createPost(@RequestBody Post post);

    @PutMapping("/")
    @ApiOperation(value = "Update post")
    Post updatePost(@RequestBody Post post);

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete post by ID")
    void deletePostById(@PathVariable Long id);
}
