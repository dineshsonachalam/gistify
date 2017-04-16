import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class solution {


 public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a =new int[n];
        int[] b = new int[n];
        for(int i=0;i<n;i++)
        {
          a[i] = scan.nextInt();
        }
        for(int i=0;i<n;i++)
        {
          b[i] = scan.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int min_sum = 0;
        for(int i=0;i<n;i++)
        {
          int temp = a[i] - b[i];
          if(temp<0)
          {
            min_sum+=temp*(-1);
          }
          else
          {
            min_sum+=temp;
          }

        }
        System.out.println(min_sum);
   }
}
