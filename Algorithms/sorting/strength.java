import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.math.*;
class solution
{
  public static void main(String[] args) {
    Scanner scan= new Scanner(System.in);
    long mod= (long)(Math.pow(10,9)+7);
    int t=scan.nextInt();
    for (int i=0;i<t ;i++ )
    {
        int n=scan.nextInt();
        long [] a= new long[n];
        for (int k=0;k<n ;k++ ) {
          a[k]=scan.nextLong();
        }
        Arrays.sort(a);
        long max= a[n-1];
        long sum = 0;
        //no we have to find the absolute differerence
        for (int l=0;l<n;l++)
        {
            for (int j=l+1;j<n;j++)
            {
                sum+=Math.abs(a[l]-a[j]);
            }
        }
        long tot;
        tot=(sum*max)%mod;
        System.out.println(tot);


    }
  }
}
