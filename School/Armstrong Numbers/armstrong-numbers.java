//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.armstrongNumber(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static String armstrongNumber(int n){
        // code here int sum=0;
          int count = 0;
        int num = n;
        while (num>0){
            count++;
            num = num/10;
        }
        int ans = 0;
        int temp = n;
        while (temp>0){
            int digit = temp%10;
            digit = (int) Math.pow(digit,count);
            ans = ans+digit;
            temp = temp/10;
        }
        if(ans==n){
            return "Yes";
        }else{
            return "No";
        }
    }
}