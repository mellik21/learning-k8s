package com.epam.kubernetes_intensive.model;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@RequiredArgsConstructor
@ToString
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private String topic;

    @Column(name = "user_id")
    private Long userId;

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getContent() {
        return content;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
