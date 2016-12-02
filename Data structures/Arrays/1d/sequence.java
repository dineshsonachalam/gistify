import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class solution
{
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n=scan.nextInt();
    int[] a=  new int[n];
    for (int i=0;i<n;i++)
    {
        a[i]=scan.nextInt();
    }
    boolean flag = true;
    for (int i=0;i<n-1;i++)
    {
        if(a[i]>a[i+1])
        {
          flag = false;
          break;
        }
        else
        {
            a[i+1]=a[i+1]-a[i];
            a[i]=0;
        }
    }
    if(flag == false)
    {
      System.out.println("NO");
    }
    else if(a[n-1]!=0){
      System.out.println("NO");
    }
    else {
      System.out.println("YES");
    }
  }
}
