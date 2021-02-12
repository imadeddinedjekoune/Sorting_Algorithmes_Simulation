/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author Imad
 */
public class Sort {
    public static int i = -1 , j = -1 ;
    public static final int SLEEP_TIME = 1 ;
    
    public static void MySort (int Tab[])
    {
        for (i = 0 ; i < Tab.length-1 ; i++ )
        {
            for ( j = i ; j < Tab.length ; j++ )
            {
                if (Tab[i] > Tab[j] )
                {
                    int temp = Tab[i] ;
                    Tab[i] = Tab[j] ;
                    Tab[j] = temp ;
                    sleep();
                }
            }
        }
        i = -1 ;
        j = -1 ;
    }
    
    public static void bubbleSort(int[] Tab) 
    {
        boolean sorted = false;
        int temp;
        while(!sorted) 
        {
            sorted = true;
            for (i = 0; i < Tab.length - 1; i++) 
            {
                if (Tab[i] > Tab[i+1]) {
                    temp = Tab[i];
                    Tab[i] = Tab[i+1];
                    Tab[i+1] = temp;
                    j = i+1 ;
                    sorted = false;
                    sleep();
                }
            }
        }
        i = -1 ;
        j = -1 ;
    }
    
    public static void insertionSort(int[] array) 
    {
        for ( i = 1; i < array.length; i++) 
        {
            int current = array[i];
            j = i - 1;
            while(j >= 0 && current < array[j]) 
            {
                array[j+1] = array[j];
                j--;
                sleep();
            }
            array[j+1] = current;
        }
        i = -1 ;
        j = -1 ;
    }
    
    
    public static void mergeSort(int[] array, int left, int right) 
    {
        if (right <= left) return;
        int mid = (left+right)/2;
        mergeSort(array, left, mid);
        mergeSort(array, mid+1, right);
        merge(array, left, mid, right);
        for ( int i = 0 ; i < 15 ; i++ )
        {
            sleep();
        }
    }
    static void merge(int[] array, int left, int mid, int right) {
    // calculating lengths
    int lengthLeft = mid - left + 1;
    int lengthRight = right - mid;

    // creating temporary subarrays
    int leftArray[] = new int [lengthLeft];
    int rightArray[] = new int [lengthRight];

    // copying our sorted subarrays into temporaries
    for ( i = 0; i < lengthLeft; i++)
        leftArray[i] = array[left+i];
    for ( i = 0; i < lengthRight; i++)
        rightArray[i] = array[mid+i+1];

    // iterators containing current index of temp subarrays
    int leftIndex = 0;
    int rightIndex = 0;

    // copying from leftArray and rightArray back into array
    for ( i = left; i < right + 1; i++) {
        // if there are still uncopied elements in R and L, copy minimum of the two
        if (leftIndex < lengthLeft && rightIndex < lengthRight) {
            if (leftArray[leftIndex] < rightArray[rightIndex]) {
                array[i] = leftArray[leftIndex];
                leftIndex++;
            }
            else {
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
        // if all the elements have been copied from rightArray, copy the rest of leftArray
        else if (leftIndex < lengthLeft) {
            array[i] = leftArray[leftIndex];
            leftIndex++;
        }
        // if all the elements have been copied from leftArray, copy the rest of rightArray
        else if (rightIndex < lengthRight) {
            array[i] = rightArray[rightIndex];
            rightIndex++;
        }
    }
    
}
    
    private static void sleep()
    {
        try 
        {
            Thread.sleep(SLEEP_TIME);
        } 
        catch (Exception e) {
        }
        
    }
    
}
