package com.github.annilinum.javaquestionnaire.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class CreateTopicRequest {
  private MultipartFile image;
  private String question;
  private String answer;
}
