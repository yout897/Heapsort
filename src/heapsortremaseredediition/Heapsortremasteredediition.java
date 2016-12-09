/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package heapsortremaseredediition;

/**
 * @author aldic2547
 * Date: 08/12/2016
 * Purpose: To sort an array using the heap sort algorithm
 */



public class Heapsortremasteredediition {
    //A variable that keeps track of the size of the array
    private static int r;
    
    /**
     * main method
     * pre:
     * post:
     * @param args 
     */
    
    public static void main(String[] args) {
        int[] array = {3,8,4,2,1,6,4,2};//Creates the array
        
        System.out.println("Unsorted Array");  
        for (int i = 0; i < array.length; i++)  //This prints out the unsorted array
            System.out.print(array[i]+" ");   
        
        long time = System.currentTimeMillis(); //Gets the initial time for when the sorting starts
        
        sorter(array); //Sorts the array
        
        long elapsed = System.currentTimeMillis() - time; //Takes the initial time and subtracts the current time to get the length it took to sort
        
        
        System.out.println("\nSorted Array ");        
        for (int i = 0; i < array.length; i++) //Prints the sorted array
            System.out.print(array[i]+" ");
        
        System.out.println("");
        System.out.println("Time: " + elapsed); //Prints the elapsed time
    } 
    
    
    /**
     * Creates the Binary heap tree
     * pre: an integer array
     * post: the array sorted into a binary heap tree
     * @param a 
     */
    
    public static void heapify(int a[]){
        r = a.length-1; //Sets the r variable to the length of the array minus one
        
        for (int i = r/2; i >= 0; i--) //Creates the Binary heap tree, utilizing the fact that 
            maxheaper(a, i);           //the length of the array divided by 2 will give the amount of rows
                                       //required to create the Binary heap tree
    }
    
    /**
     * This method is used to sort and create the binary heap tree as seen in the heapify method
     * pre: an integer array, and the parent node value
     * post: the array sorted
     * @param a
     * @param i 
     */
    
    public static void maxheaper(int a[], int i){ 
        int leftSide = 2*i ; //Calculates the left child node, by multiplying the parent node by 2
        int rightSide = 2*i + 1; //Calculates the right child node, by multiplying the parent node by 2 plus 1 
        int max = i; //This is the value of the parent node
        if (leftSide <= r && a[leftSide] > a[i]) //Checks to see if the left child node is greater than the parent node
            max = leftSide; //If it is than we make the parent node equal to it so we can continue to compare
        if (rightSide <= r && a[rightSide] > a[max])//Checks to see if the right child node is greatr then is greater than the parent node        
            max = rightSide;//If it is than we make the parent node equal to it so we can continue to compare
 
        if (max != i){ //If the parent node doesn't equal the value of the parent node
            switcher(a, i, max);//Switch the parent node and the parent node value
            maxheaper(a, max); //And continue to check
        }
    }
    
    /**
     * Sorts the array by reducing the value of the array length to lock in the highest value
     * pre: an int array
     * post: A sorted array
     * @param a 
     */
    
    public static void sorter(int a[]){       
        heapify(a); //Creates the heap
                
        for (int i = r; i > 0; i--){
            switcher(a,0, i);//Switches first element with the last element
            r = r-1;//Reduces the value of the array length
            maxheaper(a, 0);//Sorts the heap
        }
    }     
    
    /**
     * Switch 2 elements in the array given
     * pre: an int array, the index of the first element, and the index of the second element to switch
     * post: Two values being switched
     * @param a
     * @param i
     * @param j 
     */
    
    public static void switcher(int a[], int i, int j){
        int tmp = a[i];//Sets a temporary element to the first element
        a[i] = a[j]; // Sets the first element to the second
        a[j] = tmp; //Sets the second element to the temporary value

    }
}
