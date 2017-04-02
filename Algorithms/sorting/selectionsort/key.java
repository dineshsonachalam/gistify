import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class solution {


    public static void main(String[] args) {
      Scanner scan  = new Scanner(System.in);
      int n=scan.nextInt();
      int[] a = new int[n];
      for (int i=0;i<n;i++)
      {
          a[i] = scan.nextInt();
      }
      int k =scan.nextInt();
      int[] c = new int[k];  //no of keys in keyboard
      for (int i=0;i<k ;i++)
      {
          c[i] = scan.nextInt(); //no of letters in the keys
      }

      int[] x1 = new int[m1];
    //  int[] x2 = new int[m2];

      Arrays.sort(a);
      //for x1;
      int f=0;
      int max = 0;
      int min =0;

      for(int i=0;i<m1;i++)
      {
        //It should contain one max and remaining minimum elements
        //contains one max
        if(f==0)
        {
          max = a[n-1];
          x[i] = max;
        }
        else
        {
          x[i]=a[i-1];
        }

      }



    }
}
