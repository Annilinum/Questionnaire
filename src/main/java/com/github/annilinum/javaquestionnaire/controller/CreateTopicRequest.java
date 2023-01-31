package com.github.annilinum.javaquestionnaire.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTopicRequest {
  private String question;
  private String answer;
}
