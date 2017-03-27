import java.util.*;
import java.io.*;

class solution {

      void bubblesort(int a[],int n)
      {
        for(int i=0;i<n-1;i++)
        {
          for(int j=0;j<n-i-1;j++)
          {
            if(a[j]>a[j+1])
            {
              int temp = a[j];
              a[j] = a[j+1];
              a[j+1] = temp;
            }
          }
        }
      }

    public static void main(String args[] ) throws Exception {
       Scanner scan = new Scanner(System.in);
       int n =scan.nextInt();

       int[] a= new int[n];
       int[] b = new int[n];
       for(int i=0;i<n;i++)
       {
           a[i] = scan.nextInt();

       }
       solution ob = new solution();
       ob.bubblesort(a,n);
      

       for(int i=0;i<n;i++)
       {
          b[i] = scan.nextInt();

       }
       ob.bubblesort(b,n);
       int flag =0;
       for(int i=0;i<n;i++)
       {
         if(b[i]>a[i])
         {

         }
         else
         {
           flag =1;
           break;
         }
       }
       if(flag!=0)
       {
         System.out.println("No");
       }
       else
       {
         System.out.println("Yes");
       }


    }
}
