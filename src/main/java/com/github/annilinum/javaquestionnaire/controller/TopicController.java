package com.github.annilinum.javaquestionnaire.controller;

import com.github.annilinum.javaquestionnaire.model.Category;
import com.github.annilinum.javaquestionnaire.model.Topic;
import com.github.annilinum.javaquestionnaire.service.TopicService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class TopicController {
  private TopicService topicService;

  @GetMapping("/topics")
  public String getTopicsList(Model model) {
    List<Topic> allTopics = topicService.findAll();
    model.addAttribute("topics_list", allTopics);
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
  @GetMapping("topic/{topicId}/delete")
  public String deleteTopic(@PathVariable("topicId") long topicId){
    topicService.deleteById(topicId);
    return "redirect:/";
  }

  @GetMapping("topic/{topicId}/update")
  public String updateTopicForm(@PathVariable("topicId") long topicId, Model model){
   //сборка в html?
    Topic topic = topicService.findById(topicId);
    model.addAttribute("topic", topic);
    return "update-topic.html";
  }
  @PostMapping("topic/update")
  public String updateTopic(Topic topic){
    topicService.saveTopic(topic);
    return "redirect:/";
  }
  @GetMapping("topic/{topic_id}/answer")
  public String getAnswer(@PathVariable ("topic_id") long topicId, Model model) {
    String answer = topicService.findById(topicId).getAnswer();
    model.addAttribute("answer", answer);
    String question = topicService.findById(topicId).getQuestion();
    model.addAttribute("question", question);
    model.addAttribute("topic_id", topicId);
    return "answer.html";
  }
}
