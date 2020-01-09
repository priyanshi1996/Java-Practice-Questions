//Two player X and Y are playing a game in which there are pots of gold arranged in a  line, 
//each containing some gold coins. They get alternating turns in which the player can pick a pot 
//from one of the ends of the line. The winner is the player who has a higher number of coins at the end. 
//The objective is to maximize the number of coins collected by X, assuming Y also plays optimally. 
//You are required to complete the method maxCoins which returns an integer denoting the max coins X could get while 
//playing the game. You may assume that X starts the game. 


package dynamic.programming;

import java.util.Scanner;

class PotsOfGoldenGame
{
	public static void main (String[] args)
	 {
	 Scanner s=new Scanner(System.in);
	 int T=s.nextInt();
	 while(T>0)
	 {
	    int N = s.nextInt();
	    int[] arr = new int[N];
	    for(int i=0;i<N;i++)
	        arr[i] = s.nextInt();
	    
	    int[][] first = new int[N][N];
	    int[][] second = new int[N][N];
	    for(int i=0;i<N;i++)
	        first[i][i] = arr[i];
	    for(int gap = 1;gap<N;gap++){
	        for(int i=0;i<N-gap;i++){
	            int j= i+gap;
	            if(arr[i]+second[i+1][j] > arr[j]+second[i][j-1]){
	                first[i][j] = arr[i]+second[i+1][j];
	                second[i][j] = first[i+1][j];
	            }
	            else{
	                first[i][j] = arr[j]+second[i][j-1];
	                second[i][j] = first[i][j-1];
	            }
	        }
	    }
	    
	    System.out.println(first[0][N-1]);
	    T--;
	 }
	 }
}