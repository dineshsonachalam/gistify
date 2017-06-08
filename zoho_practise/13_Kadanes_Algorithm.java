import java.io.*;
import java.util.*;
class solution
{
  public static void main(String[] args)
  {
      Scanner scan = new Scanner(System.in);
      int t = scan.nextInt();
      for(int j=0;j<t;j++)
    {
      int n = scan.nextInt();
      int[] a = new int[n];
      int max_so_far = 0;
      int max_ending_here = 0;
      for(int i=0;i<n;i++)
      {
          a[i] = scan.nextInt();
          max_ending_here = max_ending_here + a[i];
          if(max_ending_here<0)
          {
              max_ending_here = 0;
          }
          if(max_ending_here> max_so_far)
          {
              max_so_far = max_ending_here;
          }
      }
      if(max_so_far == 0)
      {
        Arrays.sort(a);
        System.out.println(a[n-1]);
      }
      else
    {
      System.out.println(max_so_far);
    }
    System.out.println();
  }
  }
}
