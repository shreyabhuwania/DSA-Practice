//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int[] a = IntArray.input(br, 2);

            int[][] mat = IntMatrix.input(br, a[0], a[1]);

            Solution obj = new Solution();
            int res = obj.findShortestPath(mat);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    
    static int[][]dirs = {{1,0},{-1,0},{0,1},{0,-1}}; 
    
    public static int findShortestPath(int[][] mat) {
        
        int n = mat.length, m = mat[0].length;
        
        Queue<int[]>queue = new LinkedList<>();
        
        /* leftmost columns check if one and adjacent nodes are not landmines then add in queue */
        
        for(int i=0;i<n;i++){
            if(mat[i][0]==1 && checkLandmines(mat,i,0,n,m))queue.add(new int[]{i,0,0});
        }
        
        /*  traverse all paths from leftmost col to rightmost col using queue and find shortest path */
        int ans = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            int[]arr = queue.poll();
            int row = arr[0], col = arr[1], dist = arr[2];
            
            /* mark visited */
            mat[row][col] = -1;
            
            /* path valid condition then store minimum */
            if(col == m-1)ans = Math.min(ans,dist+1);
            
            /* traverse all adjacent which is not landmines as well as not visited */
            for(int[]dir:dirs){
                int nrow = dir[0]+row;
                int ncol = dir[1]+col;
                
                /* visited and landmine condition */
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && mat[nrow][ncol]!=-1 && checkLandmines(mat,nrow,ncol,n,m)){
                    queue.add(new int[]{nrow,ncol,dist+1});
                }
            }
        }
        
        /* check for invalid case */
        if(ans == Integer.MAX_VALUE)return -1;
        
        return ans;
        
    }
    
    public static boolean checkLandmines(int[][]mat, int row, int col,int n, int m){
        for(int[]dir:dirs){
            int nrow = dir[0]+row;
            int ncol = dir[1]+col;
            
            /*  landmine condition */
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && mat[nrow][ncol]==0)return false;
        }
        return true;
    }
}