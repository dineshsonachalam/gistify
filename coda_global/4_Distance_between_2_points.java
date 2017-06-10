import java.io.*;
import java.util.*;
class solution
{

  public static void main(String args[])
  {
      Scanner scan = new Scanner(System.in);
      int t = scan.nextInt(); //no of test cases
      for(int i=0;i<t;i++)
    {
      int x1 = scan.nextInt();
      int y1 = scan.nextInt();
      int x2 = scan.nextInt();
      int y2 = scan.nextInt();
      // Distance between 2 points   Distance = squarerootof (x2−x1)^2+(y2−y1)^2−−−−−−−−−−−−−−−−−−√

      int x = x2 - x1;
      int y = y2 - y1;

      x= x * x;
      y = y * y;
      int sum = x+y;
      double no,root;
      no = (double) sum;
      root = Math.sqrt(no);
      root = Math.round(root);
      int number = (int) root;
      System.out.println(number);


    }
  }
}
