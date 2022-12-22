package org.springstarthere;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springstarthere.configuration.ProjectConfig;
import org.springstarthere.model.Comment;
import org.springstarthere.services.CommentService;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        CommentService commentService = context.getBean("commentService", CommentService.class);

        Comment comment = new Comment();
        comment.setAuthor("Makis");
        comment.setText("Hello Aspects!");

        String result = commentService.publishComment(comment);

        System.out.println(result);
        System.out.println(commentService.getClass());

//        commentService.deleteComment(comment);

    }

}