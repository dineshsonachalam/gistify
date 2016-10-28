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
      int t=scan.nextInt();
      for(int x=0;x<t;x++)
    {
      String s=scan.next();
      String temp="--";
      temp+=s;
      temp+="--";
      int k=0;//count of walls thats been destroyed
      char [] a= new char[temp.length()];
      for (int i=0;i<temp.length();i++)
      {
          char ch=temp.charAt(i);
          a[i]=ch;
        //  System.out.println(a[i]);
      }
      for(int i=0;i<temp.length();i++)
      {
          if(a[i]=='B')
          {
              if(a[i-1]=='W')
              {
                k++;
                a[i-1]='-';
              }
              if(a[i-2]=='W')
              {
                k++;
                a[i-2]='-';
              }
              if(a[i+1]=='W')
              {
                k++;
                a[i+1]='-';
              }
              if(a[i+2]=='W')
              {
                k++;
                a[i+2]='-';
              }
          }

      }
      System.out.println(k);
    }
  }
}
