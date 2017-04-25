import java.io.*;
import java.util.*;
class solution
{
  public int isArraySorted(int index,int[] a)
  {
    if(index==1)
    {
      return 1; //Array is in sorted order
    }
    else {
      return (a[index-1]<a[index-2] ? 0:isArraySorted(index,a);
    }
  }
  public static void main(String[] args)
  {
      Scanner scan= new Scanner(System.in);
      int n = scan.nextInt();
      int[] A =new int[n];
      for (int i=0;i<n ;i++ )
      {
          A[i] =scan.nextInt();
      }
      solution ob = new solution();
      int result = ob.isArraySorted(n,A);
      if(result==1)
      {
        System.out.println("Array is sorted");
      }
      else
      {
        System.out.println("Array is not sorted");
      }
  }
}
