package com.github.annilinum.javaquestionnaire.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class TopicRequest {
  private Long id;
  private MultipartFile image;
  private String question;
  private String answer;
}
