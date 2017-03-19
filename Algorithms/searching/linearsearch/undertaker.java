import java.io.*;
import java.util.*;
class solution
{
  public static void main(String[] args)
  {
      Scanner scan = new Scanner(System.in);
      int t = scan.nextInt();
      for(int i=0;i<t;i++)
      {
        int no = scan.nextInt();
        int flag = 0;
        if(no%21==0)
        {
          flag =1;
        //  System.out.println("Statement1 executed");
        }
        else if(flag==0)
        {
        //  System.out.println("Statement2 executed");
          String s =Integer.toString(no);
          //System.out.println(s);
          String t1 ="";
          int  f1 = 0;
          for(int j=0;j<s.length();j++)
          {
            if(s.charAt(j)=='2'&& f1==0)
            {
              t1+=s.charAt(j);
          //    System.out.println(" 1pos :T1:"+t1);
              f1 = 1;
            }
            else if(t1.equals("2") && s.charAt(j)=='1' && s.charAt(j-1)=='2') //s.charAt(j-1) -> immediate next
            {
              t1+=s.charAt(j);
              flag =1;
            //    System.out.println(" 2pos T1:"+t1);
              break; //beak for loop
            }
          }


        }

        if(flag==1)
        {
          System.out.println("The streak is broken!");
        }
        else
        {
          System.out.println("The streak lives still in our heart!");
        }

      }
  }
}
