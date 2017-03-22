import java.io.*;
import java.util.*;
class solution
{
  public static void main(String[] args)
  {
      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();//
      int[] a = new int[n+1];
      for(int i=1;i<=n;i++)
      {
        a[i] = scan.nextInt();
      }
      Arrays.sort(a);
      int q = scan.nextInt();
      int[] key = new int[q+1]; // setting up key array
      for (int i=1;i<=q;i++)
      {
        key[i] =scan.nextInt();
        int pos = binsearch(a,1,n,key[i]); //(low,high,key value)
      //  System.out.println("Position:"+pos);
      System.out.println(pos);
      }
  }
  static int binsearch(int a[],int low,int high,int key)
  {
    while(low<=high)
    {
      int mid =(low+high)/2;
      if(a[mid]<key)
      {
        low = mid+1;
      }
      else if(a[mid]>key)
      {
        high = mid-1;
      }
      else
      {
        return mid; //where the element been present
      }
    }
    return -1;//if the element is not been present
  }
}
