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
    String s=scan.next();
    int[] count = new int[10];
    for(int i=0;i<10;i++)
    {
      count[i]=0;
      System.out.println(count[i]); //set initial values
    }
    for (int i=0;i<s.length();i++)
    {
         char ch = s.charAt(i);
         System.out.println(ch);
         //count[(int) ch]++;
    }

  }


}
