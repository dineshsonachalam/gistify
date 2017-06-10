import java.io.*;
import java.util.*;
class solution
{
    public static void main(String[] args)
    {
            Scanner scan = new Scanner(System.in);
        		int t= scan.nextInt();
        		for(int l=0;l<t;l++)
        		{
        		        int total_no = scan.nextInt();
        		        int[] a = new int[total_no];
        		        for(int i=0;i<total_no;i++)
        		        {
        		                a[i] = scan.nextInt();
                        //    System.out.println(a[i]);
        		        }

        		        int mid = total_no/2; //for odd
        		        int f1 = 0; //forward
        		        int l1 = total_no-1; // backward
                  //  System.out.println("Middle:"+mid);
                  //  System.out.println("F1:"+f1);
                  //  System.out.println("L1:"+l1);
        		        if(total_no%2!=0) //odd
        		        {
        		                while((f1<mid) && (l1>mid))
        		                {
        		                    System.out.print(a[l1]+" "+a[f1]+" ");
        		                    l1--;
        		                    f1++;
        		                }
                            System.out.print(a[mid]);
        		        }
                    else
                    {
                        while(f1<l1)
                        {
                          System.out.print(a[l1]+" "+a[f1]+" ");
                          l1--;
                          f1++;
                        }
                    }
        		}
    }
}
