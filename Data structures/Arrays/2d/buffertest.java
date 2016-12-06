import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
class solution
{
  public static void main(String[] args)
  {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



      int n =  Integer.parseInt(br.readLine()); 
      /*
      int q =  Integer.parseInt(br.readLine()); //no of queries
      char[] a= new char[n+1];

      String s =br.readLine();
      for (int i=0;i<n;i++)
      {
          a[i]=s.charAt(i);
      }
      for (int m=0;m<q;m++)
      {

          int l =  Integer.parseInt(br.readLine());
          int r =  Integer.parseInt(br.readLine());
          int k =  Integer.parseInt(br.readLine());
          int size = r-l;
          l = l-1;
          r = r-1;
          k = k-1;
          char[] b = new char[size+1];
          for (int i=0;i<=size ;i++)
          {
              b[i]=a[l];
              l++;
          }
          //now we have to sort b[] array lexicographically
          Arrays.sort(b);
          if(k>size)
          {
            System.out.println("Out of range");
          }
          else
          {
            System.out.println(b[k]);
          }
      }
      */
  }
}
