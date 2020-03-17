package snackbar;

public class SnackBar {
  private static void printCustomerStatus(Customer customer) {
    System.out.println(customer.getName() + " has: $" + customer.getCashOnHand());
  }

  private static void printSnackStatus(Snack snack) {
    String status = "Name: " + snack.getName() + "\n" + "Quantity: " + snack.getQuantity() + "\n" + "Vending Machine: "
        + snack.getVendingMachine().getName() + "\n" + "Total Cost: " + snack.getTotalCost();

    System.out.println(status);
  }

  public static void main(String[] args) {
    Customer jane = new Customer("Jane", 45.25f);
    Customer bob = new Customer("Bob", 33.14f);

    VendingMachine food = new VendingMachine("Food");
    VendingMachine drink = new VendingMachine("Drink");
    VendingMachine office = new VendingMachine("Office");

    Snack chips = new Snack("Chips", 36, 1.75f, food);
    Snack chocolate = new Snack("Chocolate Bar", 36, 1f, food);
    Snack pretzel = new Snack("Pretzel", 30, 2f, food);
    Snack soda = new Snack("Soda", 24, 2.5f, drink);
    Snack water = new Snack("Water", 20, 2.75f, drink);

    jane.buyWithCash(soda.buySnack(3));

    printCustomerStatus(jane);
    printSnackStatus(soda);

    System.out.println("---");

    jane.buyWithCash(pretzel.buySnack(1));

    printCustomerStatus(jane);
    printSnackStatus(pretzel);

    System.out.println("---");

    bob.buyWithCash(soda.buySnack(2));
    printCustomerStatus(bob);
    printSnackStatus(soda);

    System.out.println("---");

    jane.addCash(10);
    printCustomerStatus(jane);

    System.out.println("---");

    jane.buyWithCash(chocolate.buySnack(2));
    printCustomerStatus(jane);
    printSnackStatus(chocolate);

    System.out.println("---");

    pretzel.addQuantity(12);
    printSnackStatus(pretzel);

    System.out.println("---");

    bob.buyWithCash(pretzel.buySnack(3));
    printCustomerStatus(bob);
    printSnackStatus(pretzel);

    System.out.println("---");
    printSnackStatus(chips);
    System.out.println("---");
    printSnackStatus(chocolate);
    System.out.println("---");
    printSnackStatus(pretzel);
    System.out.println("---");
    printSnackStatus(soda);
    System.out.println("---");
    printSnackStatus(water);

  }
}