//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            String a = S[0];
            String b = S[1];

            Solution ob = new Solution();
            System.out.println(ob.getLastDigit(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int getLastDigit(String a, String b) {
        // code here
//       int x=a.charAt(a.length()-1)-'0';//changing string to int extracting last character from the string
//       int y=Integer.parseInt(b);
      
//       if(y%4==0)
//          y=4;
//       else
//         y%=4;
        
//      return (int)Math.pow(x,y)%10;
     
//     }
// }class Solution {
  
        // Handle edge cases
        if (a.length() == 1 && a.charAt(0) == '0' && b.length() == 1 && b.charAt(0) == '0')
            return 1;
        if (a.length() == 1 && a.charAt(0) == '0')
            return 0;
        if (b.length() == 1 && b.charAt(0) == '0')
            return 1;
        
        // Get the last digit of 'a'
        int num = a.charAt(a.length() - 1) - '0';
        
        // Calculate 'b % 4'
        int numb = 0;
        for (int i = 0; i < b.length(); i++) {
            numb = numb * 10 + (b.charAt(i) - '0');
            numb %= 4;
        }
        
        // Adjust numb if it's zero
        if (numb == 0)
            numb = 4;
        
        // Calculate the last digit of num^numb
        int res = (int) Math.pow(num, numb);
        res = res % 10;
        
        return res;
    }
}
