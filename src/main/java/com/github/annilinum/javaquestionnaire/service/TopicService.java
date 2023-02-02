package com.github.annilinum.javaquestionnaire.service;

import com.github.annilinum.javaquestionnaire.model.Topic;
import com.github.annilinum.javaquestionnaire.repository.CategoryRepository;
import com.github.annilinum.javaquestionnaire.repository.TopicRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class TopicService {

  private TopicRepository topicRepository;
  private CategoryRepository categoryRepository;

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

  public void saveTopic(long category_id, Long topicId,  String question, String answer, String image) {
    Topic topic = topicId == null ? new Topic() : topicRepository.getReferenceById(topicId);
    topic.setQuestion(question);
    topic.setAnswer(answer);
    topic.setCategory(categoryRepository.getReferenceById(category_id));
    topic.setImage(image);
    saveTopic(topic);
  }
}
