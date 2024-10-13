//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int a;
            a = Integer.parseInt(br.readLine());
            
            
            int b;
            b = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.gcd(a, b);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int gcd(int a, int b) {
        // code here
        // for(int i=Math.min(a,b);i>0;i--){
        //     if(a%i==0 && b%i==0){
        //         return i;
        //     }
        // }
        while(a>0 && b>0)
        {
            if(a>b)
            a=a%b;
            else
            b=b%a;
        }  
            if(a==0)
            return b;
            else
            return a;
        
    }
}
       
