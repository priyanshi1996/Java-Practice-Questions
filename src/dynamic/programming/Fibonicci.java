//    https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/

package dynamic.programming;

import java.util.*;

class Fibonicci {
    static int mod = 1000000007;
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        while(T>0){
            long N = s.nextLong();
            int ans = findFibonicci(N);
            System.out.println(ans);
            T--;
        }
    }
    
    static int findFibonicci(long N){
        
        int[][] F = new int[][]{{1,1},{1,0}};
        power(F, N-1);
        return F[0][0];
    
    }
    
    static void power(int[][] F, long N){
        if(N==0 || N==1)
            return;
        int[][] M = new int[][]{{1,1},{1,0}};
        power(F,N/2);
        multiply(F,F);
        if(N%2!=0)  
            multiply(F,M);
    }
    
    static void multiply(int[][] A, int[][] B){
        int w = (A[0][0]*B[0][0]) + (A[0][1]*B[1][0]);
        int x = (A[0][0]*B[0][1]) + (A[0][1]*B[1][1]);
        int y = (A[1][0]*B[0][0]) + (A[1][1]*B[1][0]);
        int z = (A[1][0]*B[0][1]) + (A[1][1]*B[1][1]);
        A[0][0] = w;
        A[0][1] = x;
        A[1][0] = y;
        A[1][1] = z;
    }
    
    
}
