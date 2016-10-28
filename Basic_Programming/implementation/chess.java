import java.io.BufferedReader;
import java.io.InputStreamReader;
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
    int N=(int) Math.pow(2,n); //suppose n=2,N=4
    int arr[][]= new int[N+1][N+1]; //5*5 matrix
    int A[]= new int[N+1];
    for (int i=1;i<N+1;i++) //getting only upto index 4 of the matrix->thats what we needed
    {
        for (int j=1;j<i;j++)
        {
            arr[i][j]=scan.nextInt();
            arr[j][i]=1-arr[i][j];
        }
    }
    //now we have to find who is the winner
    //given n=2 rounds 1 loop should have only 2 looping
    for (int i=1;i<=N;i++)
    {
        A[i]=i;
    }
    for (int i=0;i<n;i++)
    {
        int k=1;
        for (int j=1;j<=N;j+=2)
        {
            if((arr[A[j]][A[j+1]]==1))
            {
              A[k]=A[j];
            }
            else
            {
              A[k]=A[j+1];
            }
            k++;
        }
        N=N/2;
        if(N==1)
        {
          System.out.println(A[1]);
        }
    }

  }
}
