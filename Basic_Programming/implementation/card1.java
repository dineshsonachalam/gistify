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
     int t=scan.nextInt();
     int x,y,c=0;
     for(int i=0;i<t;i++)
    {
     int n=scan.nextInt();
     int m=scan.nextInt();
     int k=scan.nextInt();//no of decks
     int a=scan.nextInt();
     int b=scan.nextInt();
     for (int l=0;l<k;l++)
     {
         a=scan.nextInt();
         b=scan.nextInt();
     }

     x=1;
     y=1;
     c=0;
     while(true)
    {
        			if(((x+a)>n)||((y+b)>m)||(x+a<1)||(y+b<1))
        			break;
    				c=c+1;
    				x+=a;
    				y+=b;
    }

 }
 System.out.println(c);
}
}
