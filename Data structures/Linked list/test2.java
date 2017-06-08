import java.io.*;
import java.util.*;
class solution
{
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter total no:");
    int n = scan.nextInt();
    System.out.println("Enter the nos!");
    int[] a = new int[n];
    for(int i=0;i<n;i++)
    {
      a[i] = scan.nextInt();
    }
    System.out.println("Sorting the nos");
    int size = n-1;
    for(int i=0;i<=size-1;i++)
    for (int j=i+1;j<=size;j++)
    {
        if(a[i]>a[j])
        {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
    System.out.println("Sorted elements are:");
    for (int i=0;i<=size;i++)
    {
        System.out.println(a[i]);
    }
  }
}
