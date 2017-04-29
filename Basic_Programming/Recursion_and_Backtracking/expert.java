import java.io.*;
import java.util.*;
class vav {
	  public static int SolveMagicSquare(int[][] input1)
	    {int m=0;

	    if((input1.length!=input1[0].length)){
	    	return 0;}

	    int N=(int) Math.sqrt(input1.length);
	    int n=0;
	    for(int r=2;r<=20;r++){
	    	if(r==Math.sqrt(input1.length)){
	    		n=1;
	    		break;}}
	   if(n==0){
		   return 0;	 }

	    int count=0;
	    for(int x=0;x<input1.length;x++){
	    	for(int y=0;y<input1.length;y++){
	    		if(input1[x][y]==0){
	    			count++;}
	    	}
	    }if(count==(Math.pow(N*N,2))){
	    	return 1;}


	    for(int s=0;s<input1.length;s++){int row=0,clmn=0;
	    	for(int t=0;t<input1.length;t++)
	    	{
	    		if(input1[s][t]>=1&&input1[s][t]<=N){row++;}
	    		else if(input1[s][t]>N){return 0;}
	    		if(input1[t][s]>=1&&input1[t][s]<=N){clmn++;}
	    		else if(input1[t][s]>N){return 0;}

	    	} if(row<N||clmn<N){  return 0;	}
	    	}



	    			int[][] input2=new int[N*N][N*N];
	    		if(input1[0][0]==1){
	    			if(RAndC(input1)){
	    				if(smallSqrs(input1,N)){
	    					for(int j=0;j<input2.length;j=j+N){
		    					for(int i=0;i<input2.length&&(i+N)<input2.length;i=i+N){

		    						for(int a=0;a<input1.length;a++){
		    		    				for(int b=0;b<input1.length;b++){
		    		    					input2[a][b]=input1[a][b];}}

		    						if(swapR(i,j,input2,N)){
		    							if(swapC(i,j,input2,N))
		    								continue;}
		    						else
		    							return 0;}
		    			 }	m=1;    			 	}}    }
    return m;}
public static boolean RAndC(int[][] input1){
		  for(int i=0;i<input1.length;i++){
	    		for(int j=0;j<input1.length;j++){
	    			for(int k=j+1;k<input1.length;k++){
	    				if(input1[i][j]!=0&&input1[j][i]!=0){
	    					if(input1[i][j]==input1[i][k]){
			    				return false;}
		    				if(input1[j][i]==input1[k][i]){
		    					return false;
		    				}}
	    			}}}return true;
	  }
public static boolean smallSqrs(int[][] input1,int N){
		  for(int i=0;i<input1.length;i=i+N){
  			for(int a=0;a<input1.length;a=a+N){
  					for(int x=i;x<i+N;x++){
  						for(int y=a;y<a+N;y++){
  							if(i==x&&a==y){
  								continue;}
  							else if(input1[i][a]!=0){
  								if(input1[i][a]==input1[x][y])
  									return false;
  							}

	    				}}}} return true;
	  }
public static boolean swapR(int i,int j,int[][] input2, int N)
	  {
		 int[][] input=input2;
			for(int a=j;a<(j+N) && a<input.length;a++) 	{
				for(int b=i;b<(i+N)&&(b+N)<input.length;b++)
				{
					int k=input[a][b];
					input[a][b]=input[a][b+N];
					input[a][b+N]=k;
				}}if(RAndC(input)){
					return true;}
			return false;
	  }
public static boolean swapC(int i,int j,int[][] input2,int N){
		  int[][] input=input2;
			for(int a=j;a<(j+N) && a<input.length;a++) 	{
				for(int b=i;b<(i+N)&&(b+N)<input.length;b++)
				{
					int k=input[b][a];
					input[b][a]=input[b+N][a];
					input[b+N][a]=k;

				}}if(RAndC(input)){
					return true;}
		return false;
	  }
	  public static void printM(int[][] input1,int N){
		  for(int i=0;i<N*N;i++){
			  for(int j=0;j<N*N;j++)
				  System.out.print(input1[i][j]+" ");
			  System.out.println("");
		  }
	  }
	  @SuppressWarnings("resource")
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(System.in);
        int output = 0;
        int ip1_rows = 0;
        int ip1_cols = 0;
        ip1_rows = Integer.parseInt(in.nextLine().trim());
        ip1_cols = Integer.parseInt(in.nextLine().trim());

        int[][] ip1 = new int[ip1_rows][ip1_cols];
        for(int ip1_i=0; ip1_i<ip1_rows; ip1_i++) {
            for(int ip1_j=0; ip1_j<ip1_cols; ip1_j++) {
                ip1[ip1_i][ip1_j] = in.nextInt();

            }
        }
        output = SolveMagicSquare(ip1);
        System.out.println("magic="+String.valueOf(output));
    }}
