import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class solution {

    void selection_sort(int[] a,int n)
    {
      int min;
      for (int i=0;i<n-1;i++)
      {
          //choosing the current element as  the minimum element
          min = i;
          for (int j=i+1;j<n;j++)
          {
              if(a[j]<a[min])
              {
                min = j;
              }
          }
          //swap a[i] and a[min]
          int temp = a[min];
           a[min] = a[i];
          a[i] = temp;
      }
      for (int i=0;i<n;i++)
      {
          System.out.println(a[i]);
      }

    }
    public static void main(String[] args) {
      Scanner scan  = new Scanner(System.in);
      solution ob = new solution();
      int n =scan.nextInt();
      int[] a= new int[n];
      for(int i=0;i<n;i++)
      {
        a[i] = scan.nextInt();
      }
      ob.selection_sort(a,n);

    }
}
