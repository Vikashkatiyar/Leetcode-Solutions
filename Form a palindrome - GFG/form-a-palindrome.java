//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.findMinInsertions(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int findMinInsertions(String S){
        int n=S.length();
        int lps=longestPalindromicSubsequence(S, n);
        return n-lps;
    }
    int longestPalindromicSubsequence(String str, int n){
        int[][] dp=new int[n][n];
        
        for(int g=0;g<n;g++){
            for(int i=0,j=g;j<n;i++,j++){
                if(g==0){
                    dp[i][j]=1;
                }else if(g==1){
                    dp[i][j]=str.charAt(i)==str.charAt(j)?2:1;
                }else{
                    if(str.charAt(i)==str.charAt(j)){
                        dp[i][j]=2+dp[i+1][j-1];
                    }else{
                        dp[i][j]=Math.max(dp[i][j-1], dp[i+1][j]);
                    }
                }
            }
        }
        
        return dp[0][n-1];
    }
}