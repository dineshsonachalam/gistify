import java.io.*;
import java.util.*;
class solution
{
  public static void main(String[] args)
  {
      Scanner scan = new  Scanner(System.in);
      String s = scan.next();
      int l = s.length() + 1;
       int initial_space = 0;
      int last = s.length() - 1;
      boolean flag1 = false;
      boolean flag2 = false;
      int spaces;
      if(s.length()-2 > 0)
      {
       spaces = s.length() - 2;
     }
     else
     {
        spaces = 0;
     }
     int mid = ((s.length()-1)/2)-1; //middle elements s.length = 7 +1 = 8/2 = 4 - 1 =3

     boolean flag3 = false;
     for(int i=0;i<s.length();i++)
     {
      // System.out.println("start-initial_space "+initial_space);
        for (int j=0;j<initial_space;j++)
        {
            System.out.print(" ");
        }

        if(i<=mid)
        {
            initial_space =initial_space +1;
            //System.out.println("initial_space1:"+initial_space);
        }
        else if(i>mid)
        {
          initial_space =initial_space-1;

        //  System.out.println("initial_space2:"+initial_space);
        //  System.out.println("Loop executed2");
        }


        if(i<=mid)
        {

          System.out.print(s.charAt(i));

        }
        else
        {
          System.out.print(s.charAt(last));
        }
        for(int j=0;j<spaces;j++)
        {
          System.out.print(" ");
        }
      //  System.out.println("Middle:"+s.charAt(mid+1));
      if(i>mid+1)
      {
          System.out.print(s.charAt(i));
      }
        else if(i != mid+1)
      {
        System.out.print(s.charAt(last));
      }
        last = last - 1;
        if(spaces>1 && flag1 == false)
        {
            spaces -=2;
        }
        else if((spaces==1)&&(flag2==false))
        {
            spaces =0;
            flag1 = true;
            flag2 = true;
        }
        else if (spaces==0)
        {
            spaces+=1;
        }
        else
        {
          spaces = spaces+2;
        }
        System.out.println();
     }
  }
}
