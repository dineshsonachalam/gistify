import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.math.*;
class solution
{
  public static void main(String[] args) {
    Scanner scan= new Scanner(System.in);
    int l=scan.nextInt();
    int n=scan.nextInt();
    for(int i=0;i<n;i++)
    {
    	int w=scan.nextInt();
    	int h=scan.nextInt();
    	if(w<l || h<l)
    	{
        System.out.println("UPLOAD ANOTHER");

    	}
    	else if(w>=l && h>=l)
    	{
    		if(w==h)
    		{
    			System.out.println("ACCEPTED");
    		}
    		else
    		{
    		      System.out.println("CROP IT");
    		}
    	}
    }
  }

}
