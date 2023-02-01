package com.github.annilinum.javaquestionnaire.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import static com.github.annilinum.javaquestionnaire.controller.UploadController.UPLOAD_DIRECTORY;

@Service
@AllArgsConstructor
public class ImageService {

  @SneakyThrows public String saveImage(MultipartFile image) {
    Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, image.getOriginalFilename());
    Files.write(fileNameAndPath, image.getBytes());
    return fileNameAndPath.toString();
  }
}