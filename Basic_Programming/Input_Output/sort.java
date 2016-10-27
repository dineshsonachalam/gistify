import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.math.*;
class TestClass {
    public static void main(String args[] ) throws Exception {

		    Scanner scan= new Scanner(System.in);
        int t=scan.nextInt();
        for (int x=0;x<t;x++) {
          int n=scan.nextInt();
          int[] a= new int[n];
          for (int i=0;i<n;i++)
          {
              a[i]=scan.nextInt();
          }
          //Bubble sort
          int temp=0;
          for (int i=0;i<n-1;i++) {
            for (int j=0;j<n-i-1;j++)
            {
              if(a[j]>a[j+1])
              {
                temp=a[j];
                a[j]=a[j+1];
                a[j+1]=temp;
              }
            }
          }

          int r=n-1;
          for (int i=0;i<n;i++)
          {

              System.out.print(a[r]+" ");
              r--;
          }

        }

    }
}
