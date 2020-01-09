//Given a number, in the form of an array a[] containing digits from 1 to 9(inclusive). 
//The task is to find the next smallest palindrome larger than this number.

package practice;
import java.util.Scanner;

class NextSmallestPalindrome
 {
	public static void main (String[] args){
    	 Scanner s=new Scanner(System.in);
    	 int T=s.nextInt();
    	 while(T>0){
    	    int N = s.nextInt();
    	    int[] arr = new int[N];
    	    for(int i=0;i<N;i++)
    	        arr[i]=s.nextInt();
    	    int left = (N-1)/2;
    	    int right = N/2;
    	    if(checkIfAllNine(N,arr)){ //9999 -> 10001
    	        System.out.print(1+" ");
    	        for(int i=1;i<N;i++)
        	        System.out.print(0+" ");
        	    System.out.print(1+" ");
    	    }
    	    else{
        	    Pair pair = findDifferentPair(N,arr,left,right);
        	    
        	    if(pair.left<0 && pair.right>=N){ // Already Palindrome 1331 -> 1441 or 1991 -> 2001
        	       findLargestPalindrome(N,arr,left,right,1);
        	    }
        	    else{
        	        if(arr[pair.left]>arr[pair.right]) 
        	            findLargestPalindrome(N,arr,pair.left,pair.right,0); // 1321 -> 1331
        	        else
        	            findLargestPalindrome(N,arr,left,right,1); // 1231 -> 1331
        	    }
        	    for(int i=0;i<N;i++)
        	        System.out.print(arr[i]+" ");
    	    }
    	    System.out.println();
    	    T--;
    	 }
	 }
	 public static Pair findDifferentPair(int N, int[] arr, int left, int right){
	     while(left>=0 && right<N){
	         if(arr[left]==arr[right]){
	             left--;
	             right++;
	         }
	         else{
	             return new Pair(left, right);
	         }
	     }
	     return new Pair(left, right);
	 }
	 
	 public static void findLargestPalindrome(int N, int[] arr, int left, int right, int carry){
    	    while(left>=0 && right<N){
    	        int no = (arr[left]+carry)%10;
    	        carry = (arr[left]+carry)/10;
    	        arr[left] = no;
    	        arr[right] = no;
    	        left--;
    	        right++;
    	    }
	 }
	 
	 public static boolean checkIfAllNine(int N, int[] arr){
	     for(int i=0;i<N;i++){
	         if(arr[i]!=9)
	            return false;
	     }
	     return true;
	 }
}

class Pair{
    int left,right;
    Pair(int left, int right){
        this.left = left;
        this.right = right;
    }
}

