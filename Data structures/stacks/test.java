import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
class solution
{
  public static void main(String[] args)
  {
      ArrayList<Integer> al = new ArrayList<Integer>();
      al.add(1);
      al.add(2);
      al.add(3);
      Iterator itr = al.iterator();
      int size =al.size();

      while (size>0)
      {
          System.out.println(itr.next());
          size--;
      }

  }
}
