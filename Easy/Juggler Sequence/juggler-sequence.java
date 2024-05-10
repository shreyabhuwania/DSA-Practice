//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            StringBuilder out = new StringBuilder();
            ans = ob.jugglerSequence(n);
            for (int i = 0; i < ans.size(); i++) out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
public static void solve(ArrayList<Integer> ans, int n){
        if(n==1){
            ans.add(1);
            return;
        }
        else if(n%2==0){
            ans.add(n);
            solve(ans,(int)Math.pow(n,0.5));
        }
        else{
            ans.add(n);
            solve(ans,(int)Math.pow(n,1.5));
        }
    }
    
    static List<Integer> jugglerSequence(int N){
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        solve(ans,N);
        return ans;
    }
}