import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class solution
{
  public static void main(String[] args)
  {
      LinkedHashSet<String> al =  new LinkedHashSet<String>(); //contains only unique elements & maintains insertion order
      al.add("ravi");
      al.add("vijay");
      al.add("ravi");
      al.add("ajay");
      Iterator<String> itr = al.iterator();
      while(itr.hasNext())
      {
        System.out.println(itr.next());
      }
  }
}
