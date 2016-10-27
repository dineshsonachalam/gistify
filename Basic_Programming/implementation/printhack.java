//to find the no of word formation
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
    int l=scan.nextInt();
    String s=scan.next();
    int h=0,a=0,c=0,k=0,e=0,r=0,t=0;
    for (int i=0;i<s.length();i++ )
    {
        char ch=s.charAt(i);
        if(ch=='h')
        {
            h++;
        }
        else if(ch=='a')
        {
           a++;
        }
        else if (ch=='c')
        {
           c++;
        }
        else if (ch=='k')
        {
            k++;
        }
        else if (ch=='e')
        {
            e++;
        }
        else if (ch=='r')
        {
            r++;
        }
        else if (ch=='t')
        {
            t++;
        }
    }
    h=h/2;
    a=a/2;
    c=c/1;
    k=k/1;
    e=e/2;
    r=r/2;
    t=t/1;
    int [] x= new int[7];
    x[0]=h;
    x[1]=a;
    x[2]=c;
    x[3]=k;
    x[4]=e;
    x[5]=r;
    x[6]=t;
    /*
    for (int i=0;i<7 ;i++ ) {
    System.out.println(x[i]);
    }
    */
    Arrays.sort(x);
    System.out.println(x[0]);
  //  System.out.println(Math.min(h,a,c,k,e,r,t));
//  System.out.print(h+" "+a+" "+c+" "+k+" "+e+" "+r+" "+t);

  }
}
