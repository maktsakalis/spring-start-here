package configuration;

import beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import beans.Parrot;
import org.springframework.context.annotation.Primary;

@Configuration
//@ComponentScan("beans")
public class ProjectConfig {

  @Bean
  public Parrot parrot() {
    Parrot p = new Parrot();
    p.setName("Koko");
    return p;
  }

  @Bean
  public Parrot parrot2() {
    Parrot p = new Parrot();
    p.setName("Mike");
    return p;
  }

   @Bean
   public Person person() {
   Person person = new Person(parrot());
   person.setName("Makis");
   return person;
   }

    @Bean
    public Person person2(Parrot parrot2) {
        Person person = new Person(parrot2);
        person.setName("Makis");
        return person;
    }
}
