package animalia;

public class Fish extends Animal {
  public Fish(String name, int yearNamed) {
    super(name, yearNamed);
  }

  public String move() {
    return "swim";
  }

  public String breath() {
    return "gills";
  }

  public String reproduce() {
    return "eggs";
  }
}