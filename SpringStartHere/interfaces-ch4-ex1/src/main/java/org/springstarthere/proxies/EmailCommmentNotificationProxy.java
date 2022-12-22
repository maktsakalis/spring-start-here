package org.springstarthere.proxies;

import org.springframework.stereotype.Component;

@Component
public class EmailCommmentNotificationProxy implements CommentNotificationProxy {
    @Override
    public void sendComment() {
        System.out.println("Sending an email notification!");
    }
}
