package piggybank;

import java.text.DecimalFormat;

public class Main {
  public static void main(String[] args) {
    PiggyBank piggyBank = new PiggyBank();
    DecimalFormat fp = new DecimalFormat("$###,###.00");

    piggyBank.add(new Coin(CoinType.DIME, 1));
    piggyBank.add(new Coin(CoinType.QUARTER, 1));
    piggyBank.add(new Coin(CoinType.DOLLAR, 5));
    piggyBank.add(new Coin(CoinType.NICKEL, 3));
    piggyBank.add(new Coin(CoinType.DIME, 7));
    piggyBank.add(new Coin(CoinType.DOLLAR, 1));
    piggyBank.add(new Coin(CoinType.PENNY, 10));

    piggyBank.printContents();

    float totalValueDollars = piggyBank.getTotalValueCents() / 100f;

    System.out.println("The piggy bank holds " + fp.format(totalValueDollars));
  }
}