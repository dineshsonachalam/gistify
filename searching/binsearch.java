import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class solution
{
  public static void main(String[] args) {
    Scanner scan= new Scanner(System.in);
    int n=scan.nextInt();
    int[] a= new int[n];
    for (int i=0;i<n;i++)
    {
      a[i]=scan.nextInt();
    }
    Arrays.sort(a);
    solution ob= new solution();
    System.out.println("Enter key");
    int k=scan.nextInt();
  int result=  ob.binarysearch(a,0,n-1,k);
  System.out.println(result);
  }
  int binarysearch(int a[],int low,int high,int key)
  {
    /*for (int i=0;i<=high ;i++ ) {
      System.out.println(a[i]);
    }
    */
    while(low<high)
    {
      int mid=(low+high)/2;
      if(a[mid]<key)
      {
        low=mid+1;
      }
      else if(a[mid]>key)
      {
        high= mid-1;
      }
      else
      {
        return mid;
      //  break;
      }
    }
    return low;
  }
}
