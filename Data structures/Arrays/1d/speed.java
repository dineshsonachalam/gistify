import java.io.*;
import java.util.*;
class solution
{
  public static void main(String[] args) {

    Scanner scan= new Scanner(System.in);
    int t_cases=scan.nextInt();
    for (int l=0;l<t_cases;l++)
    {
        int n=scan.nextInt(); //no of cars
        int[] a= new int[100000];
        for (int i=1;i<=n ;i++ )
        {
            a[i]=scan.nextInt();
        }
        int max=a[1];
        int comp = max; //comparison
        int c=1;
        for (int i=2;i<=n ;i++)
        {
            if ( (a[i]<max) && (a[i]<a[i-1]) && (a[i]<comp) )
            {
                c++;
                comp=a[i];
            }
        }

      System.out.println(c);

    }
  }
}
