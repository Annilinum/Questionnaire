package com.github.annilinum.javaquestionnaire.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.annilinum.javaquestionnaire.model.Category;
import com.github.annilinum.javaquestionnaire.service.CategoryService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class CategoryController {
  private CategoryService categoryService;

  @SneakyThrows @GetMapping("/")
  public String getCategoriesList(Model model) {
    List<Category> allCategories = categoryService.findAll();
    model.addAttribute("categories_list", allCategories);

/*    var list = List.of("1", "wer");
    var d = new HashMap<String, String>();
    for(String item: list) {
      d.put(book.name, book.ImageUrl);
    }*/


    /*var list = List.of("1", "wer");
    var d = "{";
    for(String item: list) {
      d = d + "{" + item + ": null}";
    }
    d = d + "}";*/

    var mm = Map.of(
        "Apple", "https://i1.sndcdn.com/artworks-000412607283-nrgtef-t240x240.jpg",
        "Google", "https://i1.sndcdn.com/artworks-000412607283-nrgtef-t240x240.jpg",
        "Alphine", "https://i1.sndcdn.com/artworks-000412607283-nrgtef-t240x240.jpg",
        "Smont", "https://i1.sndcdn.com/artworks-000412607283-nrgtef-t240x240.jpg",
        "Galia", "https://i1.sndcdn.com/artworks-000412607283-nrgtef-t240x240.jpg"
    );
    String json = new ObjectMapper().writeValueAsString(mm);
    model.addAttribute("categories_data", json);

    return "categories-list.html";
  }

  @GetMapping("/category/{category_id}/topics")
  public String getCategoryTopics(@PathVariable("category_id") long category_id, Model model) {
    model.addAttribute("category_id", category_id);
    model.addAttribute("topics_list", categoryService.getTopicsListByCategoryId(category_id));
    return "topics-list.html";
  }
}
