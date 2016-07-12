
package com.craigdearden.finance;

public class CreditCardValidator {
  
  /**
   * Sixteen digit credit card number.
   */
  private long number;

  /**
   * Object must be instantiated with user input.
   */
  private CreditCardValidator() {}
  
  /**
   * @param number the credit card number to set.
   * @throws IllegalArgumentException if the number is not 16 digits.
   */
  CreditCardValidator(long number) throws IllegalArgumentException {
    if (String.valueOf(number).length() != 16) {
      throw new IllegalArgumentException("Card number must have 16 digits.");
    }

    this.number = number;
  }

  
  /**
   * 
   * Uses the Luhn Algorithm to validate a credit card number. 
   * 
   * The array is split into an integer array (so that operations can 
   * be done on each digit) 
   * 
   * The first and then every other digit is doubled. This number takes the 
   * place of the original digit unless the result is greater than 10. In 
   * this case it is divided by 10. One is added to the remainder. This
   * new number takes place of the original digit.
   * 
   * These 16 new digits are added together. If the sum is divisible by 10 then
   * the credit card is valid.
   * 
   * @return true if the credit card is valid according to the Luhn Algorithm.
   * @throws NumberFormatException if the 
   */
  public boolean isValid() {
    boolean valid = false;
    int[] ccNum = new int[16];
    
    for (int i = 0; i < 16; i++) {
      ccNum[i] = Integer.parseInt(String.valueOf(number).substring(i, i+1));
    }

    long sum = 0;
    for (int i = 0; i < 16; i++) {
      int digit = ccNum[i];
      if ((i % 2) == 0) {
        digit *= 2;
        if (digit > 10) {
          digit = 1 + (digit % 10);
        }
      }
      sum += digit;
    }

    if ((sum % 10) == 0) {
      valid = true;
    }

    return valid;
  }
}
