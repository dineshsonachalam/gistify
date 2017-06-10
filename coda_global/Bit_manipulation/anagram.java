import java.io.*;
import java.util.*;
class solution
{
    public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      String s1 = scan.next();
      String s2 = scan.next();
      char a[] = s1.toCharArray();
      char b[] = s2.toCharArray();
      if(s1.length()!= s2.length())
      {
          System.out.println("Not an anagram!");
      }
      else if(s1.length()==s2.length())
      {
          Arrays.sort(a);
          Arrays.sort(b);
          boolean b = false;
          for(int i=0;i<s.length();i++)
          {
              if(a[i]!=b[i])
              {
                  b = true;
                  break;
              }
          }
          if(b==false)
          {
              System.out.println("its an anagram");
          }
          else
          {
              System.out.println("Its not an anagram");
          }
      }
    }
}
