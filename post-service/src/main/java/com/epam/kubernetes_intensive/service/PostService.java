package com.epam.kubernetes_intensive.service;

import com.epam.kubernetes_intensive.dao.PostRepository;
import com.epam.kubernetes_intensive.model.Post;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;


@Slf4j
@Service
public class PostService {


    private final RestTemplate restTemplate;

    private final PostRepository postRepository;

    private final String userServiceUrl;


    @Autowired
    public PostService(RestTemplate restTemplate, PostRepository postRepository,
                       @Value("${user.service.url}") String userServiceUrl) {
        this.restTemplate = restTemplate;
        this.postRepository = postRepository;
        this.userServiceUrl = userServiceUrl;
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("Post with id = {} doesn't exist", id)
        ));
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Transactional
    public void deleteById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("Post with id = {} doesn't exist", id)
        ));
        postRepository.deleteById(id);

        updateNumberOfPost(post.getUserId(), false);
    }

    @Transactional
    public void createPost(Post post) {
        postRepository.save(post);

        updateNumberOfPost(post.getUserId(), true);
    }

    public Post updatePost(Post post) {
        Post post1 = postRepository.save(post);

        log.info("POST WAS UPDATED -> "+post1);

        System.out.println("POST WAS UPDATED -> "+post1);

        return post1;
    }

    private void updateNumberOfPost(Long userId, boolean isPositive) {
        String uriString = UriComponentsBuilder.fromHttpUrl(userServiceUrl + userId)
                .queryParam("isPositive", isPositive).toUriString();

        restTemplate.put(uriString, HttpMethod.PUT);
    }
}
