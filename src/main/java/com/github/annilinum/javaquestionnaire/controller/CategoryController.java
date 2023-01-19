package com.github.annilinum.javaquestionnaire.controller;

import com.github.annilinum.javaquestionnaire.model.Category;
import com.github.annilinum.javaquestionnaire.service.CategoryService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class CategoryController {
  private CategoryService categoryService;

  @GetMapping("/")
  public String getCategoriesList(Model model) {
    List<Category> allCategories = categoryService.findAll();
    model.addAttribute("categories_list", allCategories);
    return "categories-box.html";
  }
}
