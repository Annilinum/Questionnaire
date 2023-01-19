package com.github.annilinum.javaquestionnaire.controller;

import com.github.annilinum.javaquestionnaire.model.Topic;
import com.github.annilinum.javaquestionnaire.service.TopicService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class TopicController {
  private TopicService topicService;

  @GetMapping("/")
  public String getTopics() {
    List<Topic> allTopics = topicService.findAll();
    return "topics-list.html";
  }

  @GetMapping("/topic/create")
  public String createTopicForm(Topic topic) {
    return "create-topic.html";
  }

  @PostMapping("/topic/create")
  public String createTopic(Topic topic) {
    topicService.saveTopic(topic);
    return "redirect:/";
  }
  @GetMapping("/topic/{topicId}/delete")
  public String deleteTopic(@PathVariable("topicId") long topicId){
    topicService.deleteById(topicId);
    return "redirect:/";
  }

  @GetMapping("/topic/{topicId}/update")
  public String updateTopicForm(@PathVariable("topicId") long topicId){
   //сборка в html?
    return "update-topic.html";
  }
  @PostMapping("/topic/update")
  public String updateTopic(Topic topic){
    topicService.saveTopic(topic);
    return "redirect:/";
  }
}
