/* Author:      Craig Dearden
 * Date:        Jun 21, 2016
 * Name:        CreditCardValidator.java
 * Description: 
 */


package com.craigdearden.finance;

/**
 *
 * @author C1
 */
public class CreditCardValidator {
    private long _number;
    
    CreditCardValidator() {
        _number = 0;
    } 
    
    
    CreditCardValidator(long number) throws IllegalArgumentException {  
        if(String.valueOf(number).length() == 16) {
            _number = number;
        } else {
            throw new IllegalArgumentException("Card number must have 16 digits.");
        }
    }
    
    public boolean isValid() {
       boolean valid = false;
       long number = _number;
       int[] ccNum = new int[16];
       long sum = 0;
       
       long remainder; 
       for(int i = 0; i < 16; i++) {
           ccNum[i] = Integer.parseInt(String.valueOf(_number).substring(i, i));
       }
       
       for(int i = 0; i < 16; i++) {
           int digit = ccNum[i];
           
           if((i % 2) == 0) {
               digit *= 2;
               if(digit > 10) {
                   digit = 1 + (digit % 10);
               }
           } 
           System.out.println(String.valueOf(digit));
           sum += digit;
       }
       
       if((sum % 10) == 0) {
           valid = true;
       }
       
       return valid;
    }
}
