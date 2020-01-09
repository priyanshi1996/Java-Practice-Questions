package practice;

import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t>0){
            int n = s.nextInt();
            int[] arr = new int[n];
            
            Comparator<Time> comparator = (t1, t2) -> {
                if(t1.time<t2.time)
                    return -1;
                else if(t1.time>t2.time)
                    return 1;
                else if(t1.ch == 'L')
                    return -1;
                else
                    return 1;
            };
            Time[] timeList = new Time[2*n];
            
            for(int i=0;i<2*n;i+=2){
                int T1 = s.nextInt();
                int T2 = s.nextInt();
                timeList[i] = new Time(T1,'L');
                timeList[i+1] = new Time(T2, 'R');
            }
            Arrays.sort(timeList, comparator);
            int count = 0, max = 0;
            for(int i=0;i<2*n;i++){
                Time time = timeList[i];
                if(time.ch == 'L')
                    count++;
                else
                    count--;
                max = Integer.max(count,max);
            }
            System.out.println(max);
            t--;
        }

    }
}
class Time{
    int time;
    char ch;
    Time(int time, char ch){
        this.time = time;
        this.ch = ch;
    }
}
