package com.github.annilinum.javaquestionnaire.controller;

import com.github.annilinum.javaquestionnaire.model.Topic;
import com.github.annilinum.javaquestionnaire.repository.TopicRepository;
import com.github.annilinum.javaquestionnaire.service.ImageService;
import com.github.annilinum.javaquestionnaire.service.TopicService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class TopicController {
  private TopicService topicService;
  private ImageService imageService;
  private TopicRepository topicRepository;

  @GetMapping("/topics")
  public String getTopicsList(Model model) {
    List<Topic> allTopics = topicService.findAll();
    model.addAttribute("topics_list", allTopics);
    return "topics-list.html";
  }

  @GetMapping("/category/{category_id}/topic/create")
  public String createTopicForm(@PathVariable("category_id") long categoryId, Topic topic) {
    return "create-topic.html";
  }

  @GetMapping("/category/{category_id}/topic/{topic_id}/update")
  public String updateTopicForm(@PathVariable("category_id") long categoryId, @PathVariable("topic_id") long topicId,
      Model model) {
    Topic topic = topicService.findById(topicId);
    model.addAttribute("topic", topic);
    model.addAttribute("category_id", categoryId);
    return "update-topic.html";
  }

  @PostMapping("/category/{category_id}/topic/save")
  public String saveTopic(@PathVariable("category_id") long categoryId,
      @ModelAttribute(name = "topic") TopicRequest topic) {
    String path = null;
    if (!topic.getImage().isEmpty()) {
      path = imageService.saveImage(topic.getImage());
    } else if (topic.getId() != null) {
      path = topicRepository.getReferenceById(topic.getId()).getImage();
    }
    topicService.saveTopic(categoryId, topic.getId(), topic.getQuestion(), topic.getAnswer(), path);
    return "redirect:/category/" + categoryId + "/topics";
  }

  @GetMapping("/category/{category_id}/topic/{topic_id}/delete")
  public String deleteTopic(@PathVariable("category_id") long categoryId, @PathVariable("topic_id") long topicId,
      Model model) {
    model.addAttribute("topic_id", topicId);
    topicService.deleteById(topicId);
    return "redirect:/category/" + categoryId + "/topics";
  }

  @GetMapping("/category/{category_id}/topic/{topic_id}/answer")
  public String getAnswer(@PathVariable("topic_id") long topicId, @PathVariable("category_id") Long categoryId,
      Model model) {
    String answer = topicService.findById(topicId).getAnswer();
    model.addAttribute("answer", answer);
    String question = topicService.findById(topicId).getQuestion();
    model.addAttribute("question", question);
    model.addAttribute("topic_id", topicId);
    model.addAttribute("category_id", categoryId);
    boolean isPassed = topicService.findById(topicId).isPassed();
    model.addAttribute("isPassed", isPassed);
    return "answer.html";
  }

  @GetMapping("/category/{category_id}/topic/{topic_id}/passed")
  public String setPassed(@PathVariable("category_id") long categoryId, @PathVariable("topic_id") long topicId) {
    topicService.setPassed(topicId);
    return "redirect:/category/" + categoryId + "/topic/" + topicId + "/answer";
  }
}