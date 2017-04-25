import java.io.*;
import java.util.*;
class solution
{
  public int Print(int n)
  {
    if(n==0)
    {
      return 0; //this is terminating base case
    }
    else
    {
        System.out.println(n); //recursive call to itself again
        return Print(n-1);
    }
  }
  public static void main(String[] args)
  {
      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();
      solution sol = new solution();
      int result = sol.Print(n);
      System.out.println("Result:"+result);
  }
}
/*
Suppose n =5
Step1:
5!=0
print "5"
return 4

Step2:
4!=0
print "4"
return 3

Step3:
3!=0
print "3"
return 2

Step4:
2!=0
print "2"
return 1

Step5:
1!=0
print "1"
return 0

Step6
0==0
return 0

Visually memory Assignment looks like this
1--return 0--->2---return 0--->3----return0---->4-----return 0------>5----return 0 to main function
*/
