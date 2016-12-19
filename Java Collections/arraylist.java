import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class solution
{
  public static void main(String[] args)
  {
      ArrayList<String> al = new ArrayList<String>(); //creating ArrayList
      al.add("Dinesh");
      al.add("Will");
      al.add("Crack");
      al.add("Google");
      al.add("Inteview");
      //Iterating by means of iterator
      Iterator itr= al.iterator(); // getting iterator for ArrayList
      while(itr.hasNext())
      {
         System.out.println(itr.next());
      }
      System.out.println();
      //iterating by means of for-each loop
      for(String obj:al)
      {
        System.out.println(obj);
      }
      System.out.println();
      ListIterator<String> itr1 = al.listIterator();
      while(itr1.hasPrevious())
      {
        System.out.println(itr1.previous());
      }

  }
}
