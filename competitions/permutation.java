import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class solution
{
  //creating a global int variable
static int size = 100000000000000000000;
static BigInteger[] num = new BigInteger[size];
//static int[] num = new int[size];
static int count = 0;


public static void main(String[] args)
{
    Scanner scan  = new Scanner(System.in);
    String str=scan.next();
    int size = str.length();
    int input = Integer.valueOf(str);
    int fact =1;
    for(int i=1;i<=size;i++)
    {
      fact = fact*i;
    }
    size = fact;
    perm(str);
    int[] a = new int[fact+1];
    for (int i=0;i<count;i++)
    {
  //      System.out.println(num[i]);
        a[i] = num[i];
    }
    //now sorting
  //  System.out.println("Sorted");
    Arrays.sort(a);
    int pos=0;
    for (int i=1;i<=count;i++)
    {
      //  System.out.println(a[i]);
        if(a[i]==input)
        {
          pos = i;
        }
    }
    int max= a[count];

    if(input==max)
    {
      System.out.println("-1");
    }
    else
    {
  //    System.out.println("next high");
      //print the next highest
      System.out.println(a[pos+1]);

    }


}
public static void perm(String str)
{
  char[] char_arr=str.toCharArray();
  helper(char_arr,0);

}
public static void helper(char[] char_arr, int i)
{

    if(i==char_arr.length-1)
    {
          try {


            String str="";
            for(int j=0; j<char_arr.length; j++)
            {
                str=str+char_arr[j];
            }


            String lump =str;
            int n = Integer.valueOf(lump);

            num[count]=n;
        //    System.out.println(num[count]);
            count=count+1;
          //  System.out.println("COunt:"+count);


        }
        catch (Exception e) {
          //do nothing
        }

    }
    else
    {
    for(int j=i; j<char_arr.length; j++)
    {

        char tmp = char_arr[i];
        char_arr[i] = char_arr[j];
        char_arr[j] = tmp;
        helper(char_arr,i+1);

        char tmp1 = char_arr[i];
        char_arr[i] = char_arr[j];
        char_arr[j] = tmp1;

    }

}
}
}
