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

      for(char i=0;i<s1.length()-1;i++)
      {
          for(int j=i+1;j<s1.length();j++)
          {
              if(a[i]>a[j])
              {
                  char temp  = a[i];
                  a[i] = a[j];
                  a[j] = temp;
              }
          }
      }
      for(int i=0;i<s1.length();i++)
      {
          System.out.println(a[i]);
      }

      /*
      if(s1.length()!= s2.length())
      {
          System.out.println("Not an anagram!");
      }
      else if(s1.length()==s2.length())
      {
          //Arrays.sort(a);
          //Arrays.sort(b);
          boolean x = false;
          for(int i=0;i<s1.length();i++)
          {
              if(a[i]!=b[i])
              {
                  x = true;
                  break;
              }
          }
          if(x==false)
          {
              System.out.println("its an anagram");
          }
          else
          {
              System.out.println("Its not an anagram");
          }
      }
      */
    }
}
