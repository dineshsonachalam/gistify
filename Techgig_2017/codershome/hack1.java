import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class solution {


 public static void main(String[] args) {
   Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String str="";
        for(int i=0;i<a.length();i++)
        {
          if(a.charAt(i)!='0')
          {
            str+=a.charAt(i);
          }
        }
        System.out.println(str);
   }
}
