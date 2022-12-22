package org.springstarthere;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springstarthere.configuration.ProjectConfiguration;
import org.springstarthere.services.CommentService;

public class Main {
  public static void main(String[] args) {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
      ProjectConfiguration.class);

    CommentService commentService = context.getBean(CommentService.class);
    commentService.publishComment();
  }
}