import java.io.BufferedReader;
import java.io.InputStreamReader;


import java.util.*;


class TestClass {
    public static void main(String args[] ) throws Exception {


        Scanner scan= new Scanner(System.in);
        int l,k,r;
        l=scan.nextInt();
        r=scan.nextInt();
        k=scan.nextInt();
        int count=0;
        for(int i=l;i<=r;i++)
        {
        	if(i%k==0)
        	{
        		count++;
        	}
        }
        System.out.println(count);
    }
}
