import java.io.*;
import java.util.*;
class solution
{
  public static void main(String[] args)
  {
      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt(); //how many strings
      for(int i=0;i<n;i++)
      {
        String s = scan.next(); //getting the string
        String t1 ="SUVO";
        String t2 = "SUVOJIT";
        String u=""; //for checking "SUVO" //0 POSTION 'd'
        String v=""; //for checking "SUVOJIT"
        int count1 = 0; //for u
        int count2 = 0; //for v
        int f1=0;
        int f2 =0;
        int f3=0;
        int f4=0;

        //JIT
        int v1=0;
        int v2 =0;
        int v3 =0;



        for(int j=0;j<s.length();j++)
        {
          //stopping the immediate check in JIT
          int temp = 0;

          if( (s.charAt(j)=='S') && f1==0 && u.length()==0) //u.length ==0 that is empty string
          {
            u+=s.charAt(j);
            f1=1;
          //  System.out.println("1");
          }
          else if( (s.charAt(j)=='U') && f2==0 && u.length()==1) //u.length ==0 that is empty string
          {
            u+=s.charAt(j);
            f2=1;
          //  System.out.println("2");
          }
          else if( (s.charAt(j)=='V') && f3==0 && u.length()==2) //u.length ==0 that is empty string
          {
            u+=s.charAt(j);
            f3=1;
          //  System.out.println("3");
          }
          else if( (s.charAt(j)=='O') && f4==0 && u.length()==3) //u.length ==0 that is empty string
          {
            u+=s.charAt(j);
            f4=1;
          //  System.out.println("4");
          //  System.out.println(u);
            temp = 1; //stopping the immediate check of jit statement
          }

          //now for evaluation JIT STATEMENT
         if(u.equals(t1) && temp==0)
          {
            //now for JIT
        //    System.out.println("JIT STATMENT");
            //System.out.println("V:"+v);
            if( (s.charAt(j)=='J') && v.length()==0 && v1==0 )
            {
              v= u;
              v+=s.charAt(j);
              v1 = 1;
              //  System.out.println("v5:"+v);
            }
            else if( (s.charAt(j)=='I') && v.length()==5 && v2 ==0 )
            {

              v+=s.charAt(j);
              v2 = 1;
              //  System.out.println("v6:"+v);
            }
            else if((s.charAt(j)=='T') && v.length()==6 && v3==0)
            {

              v+=s.charAt(j);
              v3 =1;
            //    System.out.println("v7:"+v);
                if(v.equals(t2))
               {
                 count2+=1;
                 v=""; //set to null string
                 u="";
                 v1 =0;
                 v2 =0;
                 v3 =0;
                 f1 = 0;
                 f2 = 0;
                 f3 = 0;
                 f4 = 0;
              //    System.out.println("Count2:"+count2);
               }
            }
            else
            {
              count1+=1;
              f1 = 0;
              f2 = 0;
              f3 = 0;
              f4 = 0;
              v1 =0;
              v2 =0;
              v3 =0;
              v = "";
              u = "";
          //    System.out.println("Count1->"+count1);
            }


          }

          if(u.equals(t1)  && ( j+1 ==s.length() || s.charAt(j+1)=='S'))
          {
            count1+=1;
            f1 = 0;
            f2 = 0;
            f3 = 0;
            f4 = 0;
            v1 =0;
            v2 =0;
            v3 =0;
            v = "";
            u = "";
          //  System.out.println("Last Count1:"+count1);
          }







          /*
          //now finally occurence of "SUVO" in corresponding string
          if(u.equals(t1))
          {
            System.out.println("5");
            count1+=1;
            f1 = 0;
            f2 = 0;
            f3 = 0;
            f4 = 0;
            u=""; //empty the string u
          }
          */


        }
      //  System.out.println("final");
        System.out.println("SUVO = "+count1+", SUVOJIT = "+count2);

      }
  }
}
