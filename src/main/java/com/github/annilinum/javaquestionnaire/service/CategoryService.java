package com.github.annilinum.javaquestionnaire.service;

import com.github.annilinum.javaquestionnaire.model.Category;
import com.github.annilinum.javaquestionnaire.model.Topic;
import com.github.annilinum.javaquestionnaire.repository.CategoryRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryService {
  private CategoryRepository categoryRepository;

  public Category findById(long category_id) {
    return categoryRepository.getReferenceById(category_id);
  }

  public List<Category> findAll() {
    return categoryRepository.findAll();
  }

  public List<Topic> getTopicsListByCategoryId(long category_id) {
    return findById(category_id).getTopics();
  }
}
