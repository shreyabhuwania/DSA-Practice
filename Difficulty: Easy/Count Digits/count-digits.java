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
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.evenlyDivides(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    static int evenlyDivides(int n){
//         // code here


        int originalNumber = n; // Store the original number
        int count = 0; // Counter for divisible digits
        
        // Loop to extract each digit from the number
        while (n > 0) {
            int digit = n % 10; // Get the last digit
            
            // Check if digit is not zero and if it divides originalNumber
            if (digit != 0 && originalNumber % digit == 0) {
                count++; // Increment the count if divisible
            }
            
            n /= 10; // Remove the last digit
        }
        
        return count; // Return the count of divisible digits
    }
}
