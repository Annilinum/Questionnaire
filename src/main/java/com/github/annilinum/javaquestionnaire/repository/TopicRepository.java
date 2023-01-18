package com.github.annilinum.javaquestionnaire.repository;

import com.github.annilinum.javaquestionnaire.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}
