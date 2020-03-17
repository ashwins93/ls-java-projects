package animalia;

public class Mammal extends Animal {
  public Mammal(String name, int yearNamed) {
    super(name, yearNamed);
  }

  public String move() {
    return "walk";
  }

  public String breath() {
    return "lungs";
  }

  public String reproduce() {
    return "live births";
  }
}