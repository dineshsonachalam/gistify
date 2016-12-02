import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class solution
{
  public static void main(String[] args)
  {

  //  char a[100];
    Scanner scan = new Scanner(System.in);
    int n=scan.nextInt();
    String s = new String();
    int binary;

    int[] a= new int[100];

    for (int i=1;i<=n;i++)
    {
          a[i]= scan.nextInt();

    }
    int k =scan.nextInt(); //flipping the bits
    if(a[k]==1)
    {
      a[k]=0;
    }
    else
    {
      a[k]=1;
    }

    for (int i=1;i<=n;i++)
    {

      int temp = a[i];
      //converting the array of no into a string
      s += Integer.toString(temp);
    }
    //convert the string into no
    binary =Integer.parseInt(s);
    System.out.println("Binary:"+binary);

  }
}
