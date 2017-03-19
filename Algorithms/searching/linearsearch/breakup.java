import java.io.*;
import java.util.*;
class solution
{
  public static void main(String[] args)
  {
      Scanner scan = new Scanner(System.in);



        String s = scan.nextLine();
        //removing blankspaces
        s =s.replaceAll("\\s+","");
        //removing alphabets
        s=s.replaceAll("[\\D.]","");

        System.out.println(s);
        int date = 0;
        int some = 0;
        for(int i=0;i<s.length();i++)
        {
          if( (s.length()%2==0) &&(s.charAt(i)=='1' && s.charAt(i+1)=='9') || ( s.charAt(i)=='2' && s.charAt(i+1)=='1') )
          {
            date+=2;
          }
          else
          {
            some+=2;
          }
          i=i+1;
        }
        System.out.println("Date:"+date);
        System.out.println("Some:"+some);



  }
}
