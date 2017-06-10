import java.io.*;
import java.util.*;
class solution
{
  /*
      Recursion solution
  */
    public int func(int n)
    {
        if(n==0)
        {
            return 1;
        }
        func(n/2);
        System.out.print(n%2);
        /*
            Suppose n = 10 ===> Binary_Equivalent = 1010
            1. func(10)
               n = 10
               10 == 0 FALSE
               func(5)
               printf(n%2) /* 4. executes fourth after return : 0)
               //*Final Return 1010 -->binary equivalent to 10*/
            2. func(5)
               n = 5
               5 == 0 FALSE
               func(2)
               printf(n%2) /* 3. executes third after return : 1)
            3. func(2)
               n = 2
               2 == 0 FALSE
               func(1)
               printf(n%2) /* 2. executes second after return : 0)
            4. func(1)
               n = 1
               1 == 0 FALSE
               func(0)
               printf(n%2) /* 1. executes first after return : 1)
            5. func(0)
               n = 2
               0 == 0
               return
                  //    Goes To: Step 4(after func())  till Step 1
              return 0;

    }
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        solution sol = new solution();
        int no = sol.func(8);
        System.out.println(no);
    }
}
