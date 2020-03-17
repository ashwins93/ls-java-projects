package snackbar;

public class VendingMachine {
  private static int nextId = 0;
  private int id;
  private String name;

  public VendingMachine(String name) {
    this.id = nextId++;
    this.name = name;
  }

  public int getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }
}