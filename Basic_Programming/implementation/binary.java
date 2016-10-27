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
    Scanner scan= new Scanner(System.in);
    String s=scan.next();
    char arr[] =s.toCharArray();
    boolean flag=false;
    int count0=0;
    int count1=1;
    for (int i=0;i<s.length()-1;i++)
    {
        if((arr[i]=='1')&&(arr[i+1]=='1'))
        {
          count1++;
        }
        if((arr[i]=='0')&&(arr[i+1]=='0'))
        {
          count0++;
        }
        else
        {
            count1++;
            count0++;
        }
        if((count1>=5)||(count0>=5))
        {
          flag=true;
          break;
        }
    }
    if(flag)
    {
      System.out.println("Sorry, sorry!");
    }
    else
    {
        System.out.println("Good luck!");
    }
  }
}
