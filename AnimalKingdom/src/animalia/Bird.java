package animalia;

public class Bird extends Animal {
  public Bird(String name, int yearNamed) {
    super(name, yearNamed);
  }

  public String move() {
    return "fly";
  }

  public String breath() {
    return "lungs";
  }

  public String reproduce() {
    return "eggs";
  }
}