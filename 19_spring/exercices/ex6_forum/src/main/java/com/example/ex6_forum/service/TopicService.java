package com.example.ex6_forum.service;

import com.example.ex6_forum.model.Account;
import com.example.ex6_forum.model.Topic;
import com.example.ex6_forum.repository.TopicRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    private final HttpSession session;
    private final TopicRepository topicRepository;

    @Autowired
    public TopicService(HttpSession session, TopicRepository topicRepository) {
        this.session = session;
        this.topicRepository = topicRepository;
    }

    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    public Topic getTopicById(int id) {
        return topicRepository.findById(id).orElse(null);
    }

    public Topic createTopic(Topic topic) {
        Account account = (Account) session.getAttribute("account");
        if (account == null) return null;
        topic.setAuthor(account);
        return topicRepository.save(topic);
    }
}
