package org.springstarthere.services;

import org.springframework.stereotype.Service;
import org.springstarthere.annotations.ToLog;
import org.springstarthere.model.Comment;

import java.util.logging.Logger;

@Service
public class CommentService {

    private Logger logger = Logger.getLogger(CommentService.class.getName());

    @ToLog
    public String publishComment(Comment comment) {
        logger.info("Publishing comment: " + comment);
        return "SUCCESS";
    }

    public void deleteComment(Comment comment) {
        logger.info("Deleting comment: " + comment);
    }

    public void editComment(Comment comment) {
        logger.info("Editing comment: " + comment);
    }

}
