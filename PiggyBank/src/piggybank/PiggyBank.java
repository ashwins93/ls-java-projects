package piggybank;

import java.util.ArrayList;

public class PiggyBank {
  private ArrayList<Coin> coins = new ArrayList<>();

  public void add(Coin coin) {
    coins.add(coin);
  }

  public void printContents() {
    for (Coin coin : coins) {
      System.out.println(coin);
    }
  }

  public int getTotalValueCents() {
    int sum = 0;
    for (Coin coin : coins) {
      sum += coin.getValueCents();
    }
    return sum;
  }
}