package beans;

//@Component(value = "stereotype_person")
public class Person {

  private String name;

  private final Parrot parrot;

  public Person(Parrot parrot) {
    this.parrot = parrot;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Parrot getParrot() {
    return parrot;
  }

  @Override
  public String toString() {
    return "Person{" + "name='" + name + '\'' + ", parrot=" + parrot + '}';
  }
}
