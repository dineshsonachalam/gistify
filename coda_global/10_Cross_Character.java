import java.io.*;
import java.util.*;
class solution
{
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();
        for(int x=0;x<t;x++)
      {
        String s = scan.next();
        char[] c = s.toCharArray();
        int f = 0; //front -->increment
        int b = s.length()-1; //backward --->decrement
        int f_spaces = 0;
        int b_spaces = 0;
        int spaces_bet = s.length() - 2;
        boolean t1 = false;
        boolean t2 = false;
        int mid;
        if(s.length()%2!=0) // Odd`
        {
            mid = s.length()/2;
        }
        else  // Even
        {
            mid = (s.length() / 2)-1;
        }
        String temp ="";
        if( (s.length()%2==0 ) ) //even
        {
            temp+=String.valueOf(c[mid]);
            temp+=String.valueOf(c[mid+1]);
        }
      //  System.out.println("Temp:"+temp);
        //System.out.println("Middle:"+mid);
      //  System.out.println("S.length():"+s.length());
if( s.length()%2==0 )
{
        for(int i=0;i<s.length();i++)
        {
            //System.out.print("Spaces_F:"+f_spaces);
            //System.out.print("Spaces_B:"+f_spaces);
          //  System.out.print("Spaces_Between:"+spaces_bet);
            // Adding front spaces
            for(int j=0;j<f_spaces;j++)
            {
                System.out.print(" ");
            }
            if((i==mid) ||(i==mid+1))
            {
                System.out.print(temp);
            }
            else if(i<mid)
            {
              System.out.print(c[i]);
            }
            else if(i>mid+1)
            {
              System.out.print(c[b]);
            }
            // spaces between front and backward number
            if(i != mid ) // we have no space here between middle
            {

              for(int j=0;j<spaces_bet;j++)
              {
                System.out.print(" ");
              }


              if((i== mid+1) && t2 == false)
              {
                  t1 = true;
                  t2 = true;
              }
              else if(t1 == false)
              {
                  spaces_bet = spaces_bet - 2;
              }
              if(t1 == true)
              {
                spaces_bet +=2;
              }
            }


            if((i!=mid) ||(i!=mid+1))
        {


            if(i<mid)
            {
              System.out.print(c[b]);
            }
            else if(i>mid+1)
            {
              System.out.print(c[i]);
            }
        }
            // Adding backward spaces
            for(int j=0;j<b_spaces;j++)
            {
                System.out.print(" ");
            }
          //  System.out.println("Backward Space:"+b_spaces);
            // for the forward and the backward spaces
            if(i<mid)
            {
              f_spaces+=1;
              b_spaces+=1;
            }
            else if(i==mid+1)
            {
                //do nothing
                f_spaces-=1;
                b_spaces-=1;
            }
            else if(i>mid+1)
            {
              f_spaces-=1;
              b_spaces-=1;
            }

          //  System.out.print(c[b]);
            f++; // incrementing forward pointer
            b--; // decrementing backward pointer
            //System.out.println();
          //  System.out.println();
        }
      }
      else
      {
        for(int i=0;i<s.length();i++)
        {
            //System.out.print("Spaces_F:"+f_spaces);
            //System.out.print("Spaces_B:"+f_spaces);
          //  System.out.print("Spaces_Between:"+spaces_bet);
            // Adding front spaces
            for(int j=0;j<f_spaces;j++)
            {
                System.out.print(" ");
            }

            if(i<=mid)
            {
              System.out.print(c[i]);
            }
            else
            {
              System.out.print(c[b]);
            }
            // spaces between front and backward number
            if(i != mid) // we have no space here between middle
            {

              for(int j=0;j<spaces_bet;j++)
              {
                System.out.print(" ");
              }


              if(spaces_bet == 1 && t2 == false)
              {
                  t1 = true;
                  t2 = true;
              }
              else if(t1 == false)
              {
                  spaces_bet = spaces_bet - 2;
              }
              if(t1 == true)
              {
                spaces_bet +=2;
              }
            }
            else
            {
              spaces_bet =1;
            }


            if(i<mid)
            {
              System.out.print(c[b]);
            }
            else if(i>mid)
            {
              System.out.print(c[i]);
            }

            // Adding backward spaces
            for(int j=0;j<b_spaces;j++)
            {
                System.out.print(" ");
            }
          //  System.out.println("Backward Space:"+b_spaces);
            // for the forward and the backward spaces
            if(i<mid)
            {
              f_spaces+=1;
              b_spaces+=1;
            }
            else
            {
              f_spaces-=1;
              b_spaces-=1;
            }

          //  System.out.print(c[b]);
            f++; // incrementing forward pointer
            b--; // decrementing backward pointer
            //System.out.println();
          //  System.out.println();
        }
      }
      System.out.println();
        //System.out.println();
      }
    }
}
