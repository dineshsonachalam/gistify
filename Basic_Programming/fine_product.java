import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.math.*;
class solution
{
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n=scan.nextInt();

    int[] a=new int[n];
    BigInteger sum= new BigInteger(1);
      int sum=1;
    for (int i=0;i<n ;i++ ) {
      a[i]=scan.nextInt();
    //  sum*=a[i]%(Math.pow(10,9)+7);
    }
    for (int i=0;i<n ;i++ ) {

      sumb*=a[i]%(Math.pow(10,9)+7);

    }


    System.out.println(sum);


  }
}
