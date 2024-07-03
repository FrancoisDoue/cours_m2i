package com.example.ex6_forum.service;

import com.example.ex6_forum.model.Account;
import com.example.ex6_forum.model.Commentary;
import com.example.ex6_forum.model.Topic;
import com.example.ex6_forum.repository.CommentaryRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CommentaryService {

    private final HttpSession session;
    private final CommentaryRepository commentaryRepository;

    @Autowired
    public CommentaryService(HttpSession session, CommentaryRepository commentaryRepository) {
        this.session = session;
        this.commentaryRepository = commentaryRepository;
    }

    public void createComment(Topic topic, Commentary commentary) {
        Account account = (Account) session.getAttribute("account");
        if (account == null) return;
        commentary.setAuthor(account);
        commentary.setTopic(topic);
        commentaryRepository.save(commentary);
    }

    public Commentary replyToComment(Topic topic, Commentary commentary, Commentary reply) {
        Account account = (Account) session.getAttribute("account");
        if (account == null) return null;
        reply.setAuthor(account);
        reply.setTopic(topic);
        if (commentary.getResponses() == null) commentary.setResponses(new ArrayList<>());
        commentary.getResponses().add(reply);
        commentaryRepository.save(commentary);
        return reply;
    }

}
