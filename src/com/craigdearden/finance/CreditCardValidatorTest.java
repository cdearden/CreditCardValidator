
package com.craigdearden.finance;

public class CreditCardValidatorTest {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    CreditCardValidator card = null;

    try {
      long num = 5143250001458995L;
      card = new CreditCardValidator(num);
      String valid = card.isValid() ? "is" : "is not";
      System.out.println("Card " + valid + " valid.");
    } catch (IllegalArgumentException e) {
      System.out.println("Invalid input.");
    }
  }
}
