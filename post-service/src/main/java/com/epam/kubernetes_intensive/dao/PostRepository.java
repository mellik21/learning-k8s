package com.epam.kubernetes_intensive.dao;

import com.epam.kubernetes_intensive.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
