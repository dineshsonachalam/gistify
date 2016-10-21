import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
class solution
{
  public static void main(String[] args) {
    try {
      Scanner scan = new Scanner(System.in);
      int n=scan.nextInt(); // no of elements
      int[] a= new int[n];
      long result=1;
      long modValue=(long)(Math.pow(10,9)+7);
      for (int i=0;i<n;i++)
      {
          a[i]=scan.nextInt();
          result=result*a[i];
      }
      System.out.println(result);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
