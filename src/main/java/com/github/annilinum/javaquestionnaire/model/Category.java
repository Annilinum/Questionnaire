package com.github.annilinum.javaquestionnaire.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category {
  @Id
  private long id;

  @Column(name = "name")
  private String name;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
  public List<Topic> topics;
}
