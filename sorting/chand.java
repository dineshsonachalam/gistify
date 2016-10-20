import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.math.*;
class solution
{
  void merge(int A[],int start,int mid,int end)
  {
    int p=start,q=mid+1,k=0;
    int[] Arr= new int[end-start+1];
    for(int i=start;i<=end;i++)
    {
      if(p>mid)
      {
        Arr[k++]=A[q++];
      }
      else if(q>end)
      {
        Arr[k++]=A[p++];
      }
      else if(A[p]<A[q])
      {
        Arr[k++]=A[p++];
      }
      else
      {
        Arr[k++]=A[q++];
      }
    }
    //no we have to copy the sorted array into the orginal array
    for (int j=0;j<k;j++)
    {
        A[start++]=Arr[j];
    }
  }
  void Merge_sort(int A[],int start,int end)
  {
    if(start<end)
    {
      int mid=(start+end)/2;
      Merge_sort(A,start,mid); //sorting the left partition
      Merge_sort(A,mid+1,end);//sorting the right partition
      merge(A,start,mid,end);
    }
  }
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t=scan.nextInt(); //test cases
    solution ob = new solution();
    for (int i=0;i<t ;i++ )
    {
        int n=scan.nextInt(); //size of the array
        int[] A= new int[n];
        for (int j=0;j<n ;j++ )
        {
            A[j]=scan.nextInt();
        }
      ob.Merge_sort(A,0,n-1);
        //print the sorted array
        for (int k=n-1;k>=0;k--) {
          System.out.print(A[k]+" ");
        }
        System.out.println();
    }
  }
}
