import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.math.*;
class solution
{

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t=scan.nextInt(); //test cases

    for (int i=0;i<t ;i++ )
    {
        int n=scan.nextInt(); //size of the array
        int[] A= new int[n];
        for (int j=0;j<n ;j++ )
        {
            A[j]=scan.nextInt();
        }

        Arrays.sort(A);
        //print the sorted array
        for (int k=n-1;k>=0;k--) {
          System.out.print(A[k]+" ");
        }
        System.out.println();
    }
  }
}
