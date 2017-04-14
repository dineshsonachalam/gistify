import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class solution
{
      public static void main(String[] args)
      {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int[] a = new int[n];
        int max = 0;
        int pos1 = 0;
        for(int i=0;i<n;i++)
        {
          a[i] = scan.nextInt();
          if(max<a[i])
          {
            max = a[i];
            pos1 = i;
          }
        }
        int min = a[0];
        int pos2 = 0;
        for(int i=0;i<pos1;i++)
        {
          if(min>a[i])
          {
            min = a[i];
            pos2= i;
          }
        }
        System.out.println(pos2); //should buy

        System.out.println(pos1); //should sell


      }
}
