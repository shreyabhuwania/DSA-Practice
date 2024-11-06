//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    // Function to find the smallest positive number missing from the array.
    int missingNumber(vector<int> &arr) {
        // Your code here
        int n = arr.size();
        for(int i = 1;i<=n;i++){
            int flag = 0;
            for(int j = 0;j<n;j++){
                if(arr[j] == i){
                     flag = 1;
                     break;
                }
            }
            if(flag == 0) return i;
        }
        return n+1;
    }
};


//{ Driver Code Starts.

// int missingNumber(int arr[], int n);

int main() {

    // taking testcases
    int t;
    cin >> t;
    cin.ignore();
    while (t--) {

        vector<int> arr;
        string input;
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }

        Solution ob;
        int result = ob.missingNumber(arr);
        cout << result << "\n";

        cout << "~"
             << "\n";
    }
    return 0;
}
// } Driver Code Ends