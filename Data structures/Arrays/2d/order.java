import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);

		//StringBuilder sb = new StringBuilder();

		int[][] mat1 = new int[1001][1001];
		int[][] mat2 = new int[1001][1001];


		for(int t=1; t<=N; t++) {
			String[] query = br.readLine().split(" ");
			int x1 = Integer.parseInt(query[0]);
			int y1 = Integer.parseInt(query[1]);
			int x2 = Integer.parseInt(query[2]);
			int y2 = Integer.parseInt(query[3]);
			int c = Integer.parseInt(query[4]);

			for(int i=x1; i<=x2; i++) {
				for(int j=y1; j<=y2; j++) {
					if(mat1[i][j] != 0) {
						mat2[i][j] = 1;
					}
					mat1[i][j] += c;
				}
			}
		}

		long count = 0;

		for(int i=1; i<1001; i++) {
			for(int j=1; j<1001; j++) {
				if(mat2[i][j] == 1) {
					count+= mat1[i][j];
				}
			}
		}

        System.out.println(count);
    }
}
