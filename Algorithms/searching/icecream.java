import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class solution
{
  public static void main(String[] args) {
    Scanner scan= new Scanner(System.in);

    int t=scan.nextInt();
    for (int i=0;i<t;i++)
    {
        solution ob= new solution();
        int m=scan.nextInt(); // pool of money spent
        int n=scan.nextInt(); // no of flavours
        int[] a= new int[n];
        for (int j=0;j<n ;j++ )
        {
          a[i]=scan.nextInt(); // cost of each flavour
        }
        Arrays.sort(a); //we need to sort since we use binarysearch

      int result = ob.binarysearch(a,0,n-1,m);

      System.out.println("key:"+result);
    }
  }
  int binarysearch(int a[],int low,int high,int key)
  {

    for (int i=0;i<=high ;i++ )
    {
      System.out.println(a[i]);
    }

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
        /*
      System.out.println("Middle value:");
      for(int i=0;i<mid;i++)
      {
        System.out.println("statement executed");
          for(int j=i+1;j<mid;j++)
          {
              if((a[i]+a[j])==key)
              {
                System.out.println(a[i]+" "+a[j]);
              }
          }
      }
      */
      return mid;
      //  break;
      }
    }
    System.out.println("low:"+low);
    /*
      for(int i=0;i<low;i++)
      {
      //  System.out.println("statement executed");
          for(int j=i+1;j<low;j++)
          {
              if((a[i]+a[j])==key)
              {
                System.out.println(a[i]+" "+a[j]);

              }
          }
      }
      */


    return low;
  }
}
