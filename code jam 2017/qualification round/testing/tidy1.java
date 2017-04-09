//for BigInteger
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

      String s = scan.next(); //123;
      int l = s.length() - 1; //3-1 =2;
      int p = l;
      System.out.println("L:"+l);
      int no = 9;
      int flag = 0;
      while(l>=0) //2>=0
      {

        char c = s.charAt(l);// 3,2,1

        int x =Character.getNumericValue(c);//3
        System.out.println("X:"+x);
        if(x>0)
        {
          char[] arr = s.toCharArray(); //arr[] = [123]
          x--; //3-1 = 2;
          System.out.println("x-->"+x);
          char b =Integer.toString(x).charAt(0);
          System.out.println("B:"+b); //arr[2] = 2
          arr[l] = b; //arr[2] =2

          s = String.valueOf(arr); //122
          System.out.println(s);
          System.out.println();
          continue;  //finally we get 120
        }
        else if(x==0)
        {
           l=l-1;  //120 --> go 11
          System.out.println();
          System.out.println();

          //adding the no 9
/*
          char[] arr = s.toCharArray(); //arr[] = [120]

          System.out.println("NO-->"+no);
          char b =Integer.toString(no).charAt(0); //9
          System.out.println("B:"+b); //arr[2] = 2
          arr[l+1] = b; //arr[2] =9

          s = String.valueOf(arr); //119
          System.out.println(s); //119
          no--;//9-1=8
*/
        }
      }



    }
}
