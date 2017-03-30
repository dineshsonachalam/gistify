import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class solution {

    void insertion_sort(int[] a,int n)
    {


      int[] b = new int[n];
      for(int i=0;i<n;i++)
      {

        b[i] = a[i];
      }
      for(int i=0;i<n;i++)
    {
        int j = i;
        int temp =a[i];
        while(j>0 && temp<a[j-1])
        {
          //moving one position towards leftwards
          a[j] = a[j-1];
          j--;
        }
        //moving current element in correct position
        a[j] = temp;
      }

      for(int i=0;i<n;i++)
      {
        for(int j=0;j<n;j++)
        {
          if(b[i]==a[j])
          {
            System.out.print(j+1+" ");
          }
        }
      }
      //sorted elements

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
      ob.insertion_sort(a,n);

    }
}
