package com.github.annilinum.javaquestionnaire.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="topics")
public class Topic {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "question")
  private String question;

  @Column(name = "answer")
  private String answer;

  @Column(name = "passed")
  private boolean isPassed;

  @Column(name = "category_id")
  private long categoryIg;

  @Column(name = "next_id")
  private long nextIg;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name="category_id")
  private Category category;
}
