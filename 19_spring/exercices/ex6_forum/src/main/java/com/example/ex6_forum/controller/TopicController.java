package com.example.ex6_forum.controller;

import com.example.ex6_forum.model.Commentary;
import com.example.ex6_forum.model.Topic;
import com.example.ex6_forum.service.AccountService;
import com.example.ex6_forum.service.CommentaryService;
import com.example.ex6_forum.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;


@Controller
@RequestMapping("/topics")
public class TopicController {

    private final AccountService accountService;
    private final TopicService topicService;
    private final CommentaryService commentaryService;

    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy à HH:mm");

    @Autowired
    public TopicController(AccountService accountService, TopicService topicService, CommentaryService commentaryService) {
        this.accountService = accountService;
        this.topicService = topicService;
        this.commentaryService = commentaryService;
    }

    @GetMapping
    public String getTopics(Model model) {
        if (!accountService.isLogged()) return "redirect:/account/login";
        model.addAttribute("topics", topicService.getAllTopics());
        model.addAttribute("formatter", dateTimeFormatter);
        return "topic-list";
    }

    @PostMapping
    public String createTopic(@ModelAttribute("topic") Topic topic) {
        if (!accountService.isLogged()) return "redirect:/account/login";
        topicService.createTopic(topic);
        return "redirect:/topics/" + topic.getId();
    }

    @GetMapping("/new")
    public String newTopic(Model model) {
        if (!accountService.isLogged()) return "redirect:/account/login";
        model.addAttribute("isLogged", accountService.isLogged());
        model.addAttribute("topic", new Topic());
        return "topic-form";
    }

    @GetMapping("/{id}")
    public String showTopic(@PathVariable int id, Model model) {
        if (!accountService.isLogged()) return "redirect:/account/login";
        model.addAttribute("topic", topicService.getTopicById(id));
        return "topic-detail";
    }

    @GetMapping("/{id}/reply")
    public String newReply(@PathVariable int id, Model model) {
        if (!accountService.isLogged()) return "redirect:/account/login";
        Topic topic = topicService.getTopicById(id);
        model.addAttribute("topic", topic);
        model.addAttribute("commentary", new Commentary());
        return "commentary-form";
    }

    @PostMapping("/{id}/reply")
    public String newReply(@PathVariable int id, Commentary commentary) {
        if (!accountService.isLogged()) return "redirect:/account/login";
        Topic topic = topicService.getTopicById(id);
        System.out.println(commentary);
        commentaryService.createComment(topic, commentary);
        return "redirect:/topics/" + topic.getId();
    }

}
