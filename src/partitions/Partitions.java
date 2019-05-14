/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partitions;

import java.util.Scanner;

/**
 *
 * @author Duane
 */
public class Partitions {

    public static void print(int[] arr, int n, int count) 
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i]+" ");
        System.out.println();
        int j;
        for (j = 0; j < n; j++) 
        {
            if (arr[j] == 1)
                continue;
            else
                break;
        }
        if (j == n)
            System.out
                    .println("The number of ways to write a number as a sum of number smaller than itself is :"
                            + (count - 1));
    }
    public static void generateUniquePartition(int n) 
    {
        int[] p = new int[n];
        int k = 0, count = 0;
        p[k] = n;
        while (true) 
        {
            count++;
            print(p, k + 1, count);
            int rem_value = 0;
            while (k >= 0 && p[k] == 1) 
            {
                rem_value += p[k];
                k--;
            }
            if (k < 0)
                return;
            p[k]--;
            rem_value++;
            while (rem_value > p[k]) 
            {
                p[k + 1] = p[k];
                rem_value -= p[k];
                k++;
            }
            p[k + 1] = rem_value;
            k++;
        }
    }
    public static void main(String args[]) 
    {
        System.out.println("Enter the number:");
        Scanner key = new Scanner(System.in);
        int n = key.nextInt();
        generateUniquePartition(n);
        key.close();
    }
}
