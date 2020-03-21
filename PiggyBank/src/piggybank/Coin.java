package piggybank;

enum CoinType {
  DOLLAR, QUARTER, DIME, NICKEL, PENNY
}

public class Coin {
  private CoinType type;
  private int faceValueCents;
  private int quantity;

  public Coin(CoinType type, int quantity) {
    this.type = type;
    this.quantity = quantity;

    switch (type) {
      case DOLLAR:
        faceValueCents = 100;
        break;
      case QUARTER:
        faceValueCents = 25;
        break;
      case DIME:
        faceValueCents = 10;
        break;
      case NICKEL:
        faceValueCents = 5;
        break;
      case PENNY:
        faceValueCents = 1;
        break;
    }
  }

  private String pluralize() {
    switch (type) {
      case DOLLAR:
        return "$";
      case QUARTER:
        return quantity > 1 ? "Quarters" : "Quarter";
      case DIME:
        return quantity > 1 ? "Dimes" : "Dime";
      case NICKEL:
        return quantity > 1 ? "Nickels" : "Nickel";
      case PENNY:
        return quantity > 1 ? "Pennies" : "Penny";
      default:
        return "$";
    }
  }

  public int getFaceValueCents() {
    return faceValueCents;
  }

  public int getQuantity() {
    return quantity;
  }

  public int getValueCents() {
    return quantity * faceValueCents;
  }

  @Override
  public String toString() {
    switch (type) {
      case DOLLAR:
        return "$" + quantity;
      default:
        return quantity + " " + pluralize();
    }
  }

}