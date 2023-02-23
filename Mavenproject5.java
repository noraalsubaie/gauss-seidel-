/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject6;


import java.util.Scanner;

public class Mavenproject5 {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n, i, j, k, flag = 0, count = 0;
        System.out.println("enter the number of equation: ");
        n = in.nextInt();
        double a[][] = new double[n][n + 1];//elements of the augmented matrix
        double x[] = new double[n];//initial values of the variables
        double y;
        System.out.println("enter the elements of the augmented matrix row-wise: ");
        for (i = 0; i < n; i++) {
            for (j = 0; j <= n; j++) {
                a[i][j] = in.nextInt();
            }
        }
        
        System.out.println("enter the initial values of the variables: ");
        for (i = 0; i < n; i++) {
            x[i] = in.nextInt();
        }
        System.out.println("enter the accuracy upto which you want the solution:  ");
              double eps = in.nextDouble();
          //move first no to the end    
        for (i = 0; i < n; i++) {//pivotisation(patial)to make the equation diagonally dominant
            for (k = i+1; k < n; k++) { 
                if (Math.abs(a[i][i]) < Math.abs(a[k][i])) {
                    for (j = 0; j <= n; j++) {
                        double temp = a[i][j];
                        a[i][j] = a[k][j];
                        a[k][j] = temp;
                    }
                }
            }
        }
        System.out.print("iter   ");
        for (i = 0; i < n; i++) {
            System.out.print("x" + i + "        ");
        }
        System.out.println("");
        System.out.println("-----------------------------------------------------");
        do {        //perfom iterations to calculate x1,x2,..xn
            System.out.print((count + 1) + ".    ");
            for (i = 0; i < n; i++) {//loop that calculates x1,x2,...xn
                y = x[i]; 
                x[i] = a[i][n];// keep the last element in array x 
                for (j = 0; j < n; j++) {
                    if (j != i) {//skep the first equation
                        x[i] = x[i] - a[i][j] * x[j];//save the result in array x,a[i][j] is the cofichent  معامل ء
                    }
                } 
                x[i] = x[i] / a[i][i];//divaid the result with first no
                if (Math.abs(x[i] - y) <= eps) {//compare the ne value with the last value
                    flag++;
                }
                 System.out.printf("%.4f    " ,x[i]);
            }

            System.out.println("\t");
            count++;
        } while (flag < n);//if the values of all the variables dont differ from their previious value with error more then flag must be n and hence stop the loop
        System.out.println("the solution is as follows: ");
        for (i = 0; i < n; i++) {
             System.out.printf("x%d = %.4f\n" , i ,  x[i]);
        }
    }
}
