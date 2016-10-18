//palindromic string
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
class solution
{
  public static void main(String[] args) {
      Scanner scan= new Scanner(System.in);
      String s = scan.next();

      String x = "";

      for(int i=s.length()-1;i>=0;i--)
      {
        char ch=s.charAt(i);
    //    System.out.println(ch);
       x+=ch;
      }
    //  System.out.println(s);
    //  System.out.println(x);
      if(s.equals(x))
      {
        System.out.println("YES");
      }
      else
      {
        System.out.println("NO");
      }

  }
}
