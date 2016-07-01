/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.craigdearden.finance;

/**
 *
 * @author C1
 */
public class CreditCardValidatorDriver
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        long num = 4345345645675678L;
        CreditCardValidator card = new CreditCardValidator(num);
        
        String valid = card.isValid() ? "is" : "is not";
        
        System.out.println("Card " + valid + "valid.");
    }
    
}
