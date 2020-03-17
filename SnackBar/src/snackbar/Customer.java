package snackbar;

public class Customer {
  private static int nextId = 0;
  private int id;
  private String name;
  private float cashOnHand;

  public Customer(String name, float cashOnHand) {
    this.id = nextId++;
    this.name = name;
    this.cashOnHand = cashOnHand;
  }

  public void addCash(float cash) {
    this.cashOnHand += cash;
  }

  public void buyWithCash(float totalCost) {
    this.cashOnHand -= totalCost;
  }

  public float getCashOnHand() {
    return this.cashOnHand;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getId() {
    return this.id;
  }
}