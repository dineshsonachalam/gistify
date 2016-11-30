import java.io.*;
import java.util.*;
class solution
{
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int q=scan.nextInt();
    //Use dynamic arrray
    List<Integer> list = new ArrayList<Integer>();
    int h=0;//height of the pile
    for (int i=0;i<q;i++)
    {
        int temp=scan.nextInt(); //getting the query
        if(temp==1)
        {
          if (h==0) {
              System.out.println("No Food");
          }
          else
          {
            try
            {
              if (h>0)
              {

                int retval=list.get(h-1);
            //    System.out.println("Retval:"+retval);
                System.out.println(retval);
                list.remove(h-1); //removing the element in the list
                h--;


              }
            }
            catch (Exception e) {
              System.out.print(e);
            }
          }
        }
        if (temp==2)
        {

            int t=scan.nextInt();
            list.add(t);
            h++;

        }
    }
  }
}
