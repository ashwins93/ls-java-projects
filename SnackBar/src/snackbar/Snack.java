package snackbar;

public class Snack {
  private static int nextId = 1;
  private int id;
  private String name;
  private int quantity;
  private float cost;
  private VendingMachine vendingMachine;

  public Snack(String name, int quantity, float cost, VendingMachine vendingMachine) {
    this.id = nextId++;
    this.name = name;
    this.quantity = quantity;
    this.cost = cost;
    this.vendingMachine = vendingMachine;
  }

  public int getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public int getQuantity() {
    return this.quantity;
  }

  public float getCost() {
    return this.cost;
  }

  public VendingMachine getVendingMachine() {
    return this.vendingMachine;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void addQuantity(int quantity) {
    this.quantity += quantity;
  }

  public float buySnack(int quantity) {
    this.quantity -= quantity;
    return quantity * this.cost;
  }

  public void setCost(float cost) {
    this.cost = cost;
  }

  public void setVendingMachine(VendingMachine vendingMachine) {
    this.vendingMachine = vendingMachine;
  }

  public float getTotalCost() {
    return this.getCost() * this.getQuantity();
  }
}