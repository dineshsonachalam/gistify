import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class solution
{
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n=scan.nextInt();
    int q =scan.nextInt(); //no of queries

    //get the nos in the array
    int[] a= new int[10000000];

    for (int i=1;i<=n;i++)
    {
          a[i]= scan.nextInt();

    }


    for (int u=0;u<q;u++)
    {
        String s = new String();
        int binary;



        //now check the query input
        int q_i=scan.nextInt();
        if(q_i==1) //1-->flipping the bits
        {
            int k=scan.nextInt(); //the position to flip
            a[k]=1-a[k];

        }
        else //here we have to display the no is odd or even
        {
              int l=scan.nextInt(); //left position
              int r =scan.nextInt(); //right position

              if(a[r]==1)
              {
                System.out.println("ODD");
              }
              else {
                System.out.println("EVEN");
              }

        }
    }
  }
}
