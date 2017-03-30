import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class solution {

    void selection_sort(int[] a,int n,int x)
    {
      int min;
      for (int i=0;i<n-1;i++)
      { if(x>0)
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

          x--; //decrementing x no of steps the above algorithm to be performed respectively
        }
        else
        {
          break;
        }
      }
      for (int i=0;i<n;i++)
      {
          System.out.print(a[i]+" ");
      }

    }
    public static void main(String[] args) {
      Scanner scan  = new Scanner(System.in);
      solution ob = new solution();
      int n =scan.nextInt();
      int x = scan.nextInt();
      int[] a= new int[n];
      for(int i=0;i<n;i++)
      {
        a[i] = scan.nextInt();
      }
      ob.selection_sort(a,n,x);

    }
}
