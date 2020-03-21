package piggybank;

import java.util.ArrayList;

public class PiggyBank {
  private ArrayList<Coin> coins = new ArrayList<>();

  public void add(Coin coin) {
    coins.add(coin);
  }

  public int subtractValue(float value) {
    int valueInCents = (int) (value * 100);
    Coin currentCoin;

    ArrayList<Coin> sortedList = new ArrayList<>(coins.size());
    coins.stream().sorted((c1, c2) -> c2.getFaceValueCents() - c1.getFaceValueCents()).forEach(sortedList::add);

    for (int i = 0, numberRemoved = 0; i < sortedList.size(); i++) {
      currentCoin = sortedList.get(i);
      if (valueInCents >= currentCoin.getFaceValueCents()) {
        numberRemoved = Math.min(valueInCents / currentCoin.getFaceValueCents(), currentCoin.getQuantity());
        currentCoin.setQuantity(currentCoin.getQuantity() - numberRemoved);
        if (currentCoin.getQuantity() == 0) {
          coins.remove(currentCoin);
        }
        valueInCents -= numberRemoved * currentCoin.getFaceValueCents();
      }
    }

    return valueInCents;
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