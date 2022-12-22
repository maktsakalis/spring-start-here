package org.springstarthere;

import beans.Person;
import configuration.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Person person = context.getBean("person2",Person.class);

        System.out.println(person);
    }
}
