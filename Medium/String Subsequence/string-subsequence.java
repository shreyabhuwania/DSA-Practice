//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s1;
            s1 = br.readLine();

            String s2;
            s2 = br.readLine();

            Solution obj = new Solution();
            int res = obj.countWays(s1, s2);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int countWays(String s1, String s2) {
        // code here
        int m = s1.length(), n = s2.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1; i<=m; i++){
            int prev = 1;
            for(int j=1; j<=n; j++){
                long take = 0;
                if(s1.charAt(i-1) == s2.charAt(j-1))  take = prev;
                prev = dp[j];
                long not_take = dp[j];
                
                dp[j] = (int)((take+not_take)%1000000007);
            }
        }
        return dp[n];   
    }
}