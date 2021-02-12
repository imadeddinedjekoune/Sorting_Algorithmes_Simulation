/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.Random;

/**
 *
 * @author Imad
 */
public class Util {
    public static int [] generateRandomArray (int size , int max)
    {
        int Tab[] = new int[size];
        int i ;
        Random r  = new Random();
        
        for ( i = 0 ; i < size ; i++ )
        {
            Tab[i]  = r.nextInt((max-1))+5;
        }
        
        return Tab ;
    }
}
