package com.epam.kubernetes_intensive.resource;

import com.epam.kubernetes_intensive.model.Post;
import com.epam.kubernetes_intensive.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController implements PostAPI {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @Override
    public Post getPostById(Long id) {
        return postService.getPostById(id);
    }

    @Override
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @Override
    public void deletePostById(Long id) {
        postService.deleteById(id);

    }

    @Override
    public Post updatePost(Post post) {
       return postService.updatePost(post);
    }

    @Override
    public void createPost(Post post) {
        postService.createPost(post);
    }
}
