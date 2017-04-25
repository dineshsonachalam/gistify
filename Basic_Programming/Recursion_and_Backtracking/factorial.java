import java.io.*;
import java.util.*;
class solution
{
  public int Factorial(int n)
  {
    if(n==0)
    {
      return 1;
    }
    else
    {
      return n*Factorial(n-1);
    }
  }
  public static void main(String[] args)
  {
      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();
      //finding factorial of n numbers
      solution ob = new solution();
      int result = ob.Factorial(n);
      System.out.println(result);
  }
}
/*
Step1:
n=5
n!=0
return 5 * Factorial(4)
Step2:
n=4
n!=0;
return 4 * Factorial(3)
Step3:
n=3
n!=0
return 3 * Factorial(2)
Step4:
n=2
n!=0
return 2 * Factorial(1)
Step5:
n=1
n!=0
return 1 * Factorial(0)
Step6:
n=0
n==0
return 1

Visualization:

1 ----is returned--> 2*1! --return 2--->3*2!----return 6----->4*3!----return 24---->
5*4!---return 120--->Now return 120 to the main function

*/
