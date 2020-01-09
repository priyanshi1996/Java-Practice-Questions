//Rhezo and his friend Vanya love problem solving. They have a problem set containing N problems, 
//with points assigned to each. Rhezo wants to solve problems in such a way that he gets the maximum number of points. 
//Rhezo has a weird habit of solving only prime number of consecutive problems, that is, if he solves X consecutive problems 
//from the problem set, then X should be prime. Vanya has already solved all problems from the problem set and he wonders how much 
//maximum points Rhezo can get. Vanya can answer this, but can you?

package dynamic.programming;

import java.util.*;
class RhezoAndPrimeNumbers {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] pre = new int[N+1];
        for(int i=1;i<=N;i++){
            int val = s.nextInt();
            pre[i] = pre[i-1] + val;
        }
        
        boolean[] vis = new boolean[N+1];
        List<Integer> list = sieve(vis, N);
        int[] dp = new int[N+1];
        for(int i=2;i<=N;i++){
            dp[i] = dp[i-1];
            for(int j=0; j<list.size() && list.get(j)<=i;j++){
                int p = i-list.get(j)-1;
                if(p==-1)
                    dp[i] = Integer.max(pre[i], dp[i]);
                else
                    dp[i] = Integer.max(pre[i]-pre[p+1]+dp[p], dp[i]);
            }
        }
        System.out.println(dp[N]);
        
    }
    
    public static List<Integer> sieve(boolean[] vis, int N){
        List<Integer> list = new ArrayList();
        for(int i=2;i<=N;i++){
            if(!vis[i]){
                list.add(i);
                for(int j=i+i;j<=N;j+=i)
                    vis[j]=true;
            }
        }
        return list;
    }
}
