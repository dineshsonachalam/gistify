import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.math.*;
class solution
{
  void merge_sort(int A[],int start,int end)
  {

    if(start<end)
    {
        int mid = (start+end)/2;
        //sort 1st part of the  array
        merge_sort(A,start,mid);
        //sort 2nd part of the array
        merge_sort(A,mid+1,end);
        //Merge both parts by comparing the elements of each part
        merge(A,start,mid,end);
    }
  }
  void merge(int A[],int start,int mid,int end)
  {
    //store the starting position of both in temporary variable
    int p = start;
    int k = 0;
    int q= mid+1;
    int[] Arr = new int[start-end+1]; //array size
    for (int i=start;i<=end;i++)
    {
      //check if 1st part comes to an end
      if(p>mid)
      {
        Arr[k++] = A[q++];
      }
      //check if 2nd part comes to an end
      else if(q>end)
      {
        Arr[k++] = A[p++];
      }
      //check which has smaller element
      else if(A[p]<A[q])
      {
        Arr[k++] = A[p++];
      }
      else
      {
          Arr[k++] = A[q++];
      }

    }
    for (p=0;p<k;p++)
    {
        //now real array has elements in sorted manner includes both parts
        A[start++] = Arr[p];
        System.out.print(Arr[p]+" ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Scanner scan = new  Scanner(System.in);
    int n = scan.nextInt();
    int[] a =new int[n];
    for (int i=0;i<n;i++)
    {
        a[i] = scan.nextInt();
    }
    solution sol = new solution();
    sol.merge_sort(a,0,n-1);// Array,start,end

  }
}
