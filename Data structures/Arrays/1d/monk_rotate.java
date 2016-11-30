import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class solution
{
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t=scan.nextInt();
    for (int l=0;l<t ;l++ )
    {
        int n=scan.nextInt();
        int k=scan.nextInt();
      //to avoid overflow of the rotation
        int[] b= new int[1000000];
        for(int i=0;i<n;i++)
        {
          b[i]=scan.nextInt();

        }
          k=k%n;
        for (int i=0;i<n ;i++)
        {
            System.out.print(b[(i+(n-k))%n]+" ");
        }
    }
  }
}
