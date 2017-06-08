import java.io.*;
import java.util.*;
class solution
{
    /*

      Fibonnaci Series Formula:
      T[n] = T[n-1] + T[n-2]

      With Pre-CONDITION
        1) T[0] = 0
        2) T[1] = 1
    */
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
      //  System.out.println("Enter the no of fibonnaci elements to be:");
        int n = scan.nextInt();
        n = n+1;
        int a[] = new int[n];
        a[0] = 0;
        a[1] = 1;
        for(int i=2;i<n;i++) //we are having limit n+1 since  0 is not considered as fibonnaci no
        {
            a[i] = a[i-1] +a[i-2];
          //  System.out.println(a[i]);
        }
        System.out.print(a[n-1]);
    }
}
