package org.springstarthere.repositories;

import org.springframework.stereotype.Component;

@Component
public class DBCommentRepository implements CommentRepository {
  @Override
  public void saveComment() {
    System.out.println("Saving comment to DB ...");
  }
}
