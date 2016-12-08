

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;


class solution {
	int binsearch(int[] a,int low,int high,int key)
	{




		while(low<=high)
		{
      int mid =(low+high)/2;
			if(a[mid]<key)
			{
					low=mid+1;

			}
			else if(a[mid]>key)
			{

					high=mid-1;
			}
			if(a[mid]==key)
			{

				return mid+1;
			}
		}
		 return -1; //if no element if fowund
	}

    public static void main(String args[] ) throws Exception {


        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
		int[] a = new int[N];
        for (int i = 0; i < N; i++)
        {
        	   a[i] = scan.nextInt();
        }
        Arrays.sort(a);

		solution sol = new solution();
		int q=scan.nextInt();
		//we have to return the position
		for(int i=0;i<q;i++)
		{
			int key =scan.nextInt();
			int output = sol.binsearch(a,0,N-1,key);
			System.out.println(output);
		}


    }
}
