package animalia;

public abstract class Animal {
  private static int nextId = 0;
  private int id;
  protected String name;
  protected int yearNamed;

  public Animal(String name, int yearNamed) {
    this.id = nextId++;
    this.name = name;
    this.yearNamed = yearNamed;
  }

  public int getId() {
    return this.id;
  }

  public int getYear() {
    return this.yearNamed;
  }

  public String getName() {
    return this.name;
  }

  public String eat() {
    return this.name + " is eating food.";
  }

  public abstract String move();

  public abstract String breath();

  public abstract String reproduce();
}