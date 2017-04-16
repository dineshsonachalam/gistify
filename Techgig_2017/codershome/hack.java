import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class solution {


 public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int no = scan.nextInt();
        int count = 0;
        for(int i=1;i<=no;i++)
        {
          String a = Integer.toString(i);
          char[] b =a.toCharArray();
          int flag = 0;
          if(a.length()>1)
        {
          for(int j=1;j<a.length();j++)
          {
            //System.out.println(b[j-1]+"=="+b[j]);
            if( (b[j-1]==b[j]))
            {
              flag =1;
            //  System.out.println("Has Repeated Numbers!");
              break;
            }
          }
        }
          if(flag == 0)
          {
            count++;
            //System.out.println("count:"+count+" --> "+"No:"+a);
          }
        }
        System.out.println(count);
   }
}
