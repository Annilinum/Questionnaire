package com.github.annilinum.javaquestionnaire.service;

import com.github.annilinum.javaquestionnaire.model.Topic;
import com.github.annilinum.javaquestionnaire.repository.TopicRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class TopicService {

  private TopicRepository topicRepository;

  public Topic findById(long topicId) {
    return topicRepository.getReferenceById(topicId);
  }

  public List<Topic> findAll() {
    return topicRepository.findAll();
  }

  public Topic saveTopic(Topic topic) {
    return topicRepository.save(topic);
  }

  public void deleteById(long topicId) {
    topicRepository.deleteById(topicId);
  }
  public void setPassed(long topicId) {
    Topic topic = findById(topicId);
    boolean passed = !topic.isPassed();
    topic.setPassed(passed);
    topicRepository.save(topic);
  }
}
