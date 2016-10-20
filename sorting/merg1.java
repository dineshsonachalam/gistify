import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.math.*;
class solution
{
static public int count=0;
  private static long  merge(int A[],int start,int mid,int end)
  {
    //store the starting position of both parts in temporary variable
  //  System.out.println("merge function executed");
    long count = 0;
    int p=start,q=mid+1;
    int[] Arr = new int[end-start+1];
    int k=0;
    //for (int i=start;i<=end ;i++)
    while(p<=mid || q<=end)
    {

        if(p>mid) //check if first part comes to an end or not
        {

          Arr[k++]=A[q++];
      //      System.out.println("A[k]="+A[k]);
        }
        else if(q>end) //check if second part comes to an end or not
        {

          Arr[k++]=A[p++];

        }
        else if(A[p]<=A[q]) //check which part has smaller element
        {
          Arr[k++]=A[p++];
            System.out.println("A[k]="+A[k]);
        }
        else
        {
        //  System.out.println("Arr[k++]="+Arr[k++]+" A[q++]="+A[q++]);
      //    System.out.println("q:"+(q++));
      //    System.out.println("k="+k);

          Arr[k++]=A[q++];
          System.out.println("A[k]="+A[k]);
            count += mid + 1 - p;

        //  System.out.println("k="+k);
        //  System.out.println("q="+q);
        }
     }
/*
     for (int j=0 ; j< k ;j++) {
  /* Now the real array has elements in sorted manner including both parts.*/

  //      A[start++] = Arr[j] ;
//    }
    return count;

  }

  //2 branched recursive function

   private static long  mege_sort(int A[],int start,int end)
  {
  //  System.out.println("Merge_sort statement executed");
  long count = 0;
    if(start<end)
    {
      int mid=(start+end)/2;
      //divides the current array in 2 parts
      count +=  mege_sort(A,start,mid); //sort the first part of the array
      count +=  mege_sort(A,mid+1,end);//sort the second part of the array
      //merge the both parts by comparing elements of both the parts
      count +=  merge(A,start,mid,end);

    }
    return count;

  }
  public static void main(String[] args) {
    Scanner scan= new Scanner(System.in);
    int n=scan.nextInt();
    int[] A= new int[n];
  //  solution ob= new solution();
    for (int i=0;i<n;i++)
    {
        A[i]=scan.nextInt();
    }
    System.out.println(mege_sort(A,0,n-1));
  /*  System.out.println("Sorted Array is:");
    for (int i=0;i<n;i++)
    {
        System.out.print(A[i]+" ");
    }
    System.out.println("counting inversion:"+count);
    */

  }
}
