import java.io.*;
import java.util.*;
class solution
{
  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    String s=scan.next();
    int[] a= new int[10000];
    for (int i=0;i<s.length();i++)
    {
        a[i]=s.charAt(i);
        System.out.println(a[i]);
    }
  }

}
