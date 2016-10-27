import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class solution
{
  public static void main(String[] args)
{
    Scanner scan = new Scanner(System.in);
    int n=scan.nextInt();
    int[] A= new int[n];
    int[] B= new int[n];
    int[] C= new int[n];
    for(int i=0;i<n;i++)
    {
      A[i]=scan.nextInt();
    }
    for(int i=0;i<n;i++)
    {
      B[i]=scan.nextInt();
    }
    for(int i=0;i<n;i++)
    {
      C[i]=A[i]+B[i];
      System.out.print(C[i]+" ");
    }

  }
}
