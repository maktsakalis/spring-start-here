package org.springstarthere.services;

import org.springframework.stereotype.Component;
import org.springstarthere.proxies.CommentNotificationProxy;
import org.springstarthere.repositories.CommentRepository;

@Component
public class CommentService {

  private final CommentRepository commentRepository;

  private final CommentNotificationProxy commentNotificationProxy;

  public CommentService(CommentRepository commentRepository,
    CommentNotificationProxy commentNotificationProxy) {
    this.commentRepository = commentRepository;
    this.commentNotificationProxy = commentNotificationProxy;
  }

  public void publishComment() {
    String message = "Hello World!";
    System.out.println("Publishing a new comment..." + message);
    commentRepository.saveComment();
    commentNotificationProxy.sendComment();
  }

  public CommentRepository getCommentRepository() {
    return commentRepository;
  }

  public CommentNotificationProxy getCommentNotificationProxy() {
    return commentNotificationProxy;
  }
}
