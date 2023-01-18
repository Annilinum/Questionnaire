package com.github.annilinum.javaquestionnaire.controller;

import com.github.annilinum.javaquestionnaire.model.Topic;
import com.github.annilinum.javaquestionnaire.service.TopicService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TopicController {
  private TopicService topicService;

@GetMapping("/")
  public String getTopics(){
  List<Topic> allTopics = topicService.findAll();
    return "topics-list.html";
  }
}
