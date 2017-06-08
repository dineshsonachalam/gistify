/*
      GENERATION OF A TRIANGLE:
      1) Forward spaces = depth - 1, decrement it in every loop
      2) increment the number in for loop

  Enter the depth of the triangle:
  7
      1
     1 1
    1 1 1
   1 1 1 1
  1 1 1 1 1
 1 1 1 1 1 1
1 1 1 1 1 1 1

*/


import java.io.*;
import java.util.*;
class solution
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the depth of the triangle:");
        int n = scan.nextInt();
        int f_spaces = n - 1;
        int no = 1;
        for(int i=0;i<n;i++)
        {
            // forward spaces
            for (int j=0;j<f_spaces;j++)
            {
                  System.out.print(" ");
            }
            // no to be printed
            for(int j=0;j<no;j++)
            {
                System.out.print("1"+" ");
            }
            f_spaces--;
            no++;
            System.out.println();
        }
    }
}
