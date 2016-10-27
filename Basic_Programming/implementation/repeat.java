import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class solution
{
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String s=scan.next();
    int[] a= new int[100];
    for(int i=0;i<10;i++)
    {
       StringBuilder str = new StringBuilder(i);
      char ch = s.charAt(i);

      if(s.contains(str))
      {

        a[(int) ch]++;
      }
      else
      {
        a[i]=0;
      }
    }
    /*
    for (int i=0;i<s.length();i++ ) {
      System.out.println(a[i]);
    }
    */
  }
}
