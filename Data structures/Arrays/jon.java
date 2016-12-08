import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class solution
{
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String s =scan.next();
    int  value = Integer.parseInt(s);
  //  System.out.println(value);
    int len =s.length();
    int[] a= new int[len];
    String t;
    for (int i=0;i<len ;i++ )
    {
        char c = s.charAt(i);
        a[i] = Character.getNumericValue(c);
    }
    //factorial
    int fact=1;
for(i=1;i<=len;i++)
{
    fact=fact*i;
}
//no of different combination
  String[] num = new Strings[fact];
  for (int i=0;i<fact;i++)
  {
      for (int j=0;j<len-1;j++)
      {
          int temp = a[j];
          a[j] = a[j+1];
          a[j] = temp;
          String[i]+=
      }
  }
}
}
