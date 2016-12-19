//LinkedHashMap -> has key and value, maintains insertion order
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class solution
{
  public static void main(String[] args) {
    LinkedHashMap<Integer,String>  hm = new LinkedHashMap<Integer,String>();
    hm.put(100,"Amit");
    hm.put(101,"Vijay");
    hm.put(102,"Rahul");
    for(Map.Entry m: hm.entrySet())
    {
      System.out.println(m.getKey()+" "+m.getValue());
    }
  }
}
