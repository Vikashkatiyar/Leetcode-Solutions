//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int X = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.nodeLevel(V,list,X));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution
{
    //Function to find the level of node X.
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X)
    {
        Queue<Integer> q=new LinkedList<>();
        boolean[] vis=new boolean[V];
        q.add(0);
        vis[0]=true;
        
        int level=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int rem=q.remove();
                
                if(rem==X){
                    return level;
                }
                for(int nbr: adj.get(rem)){
                    if(vis[nbr]!=true){
                        q.add(nbr);
                        vis[nbr]=true;
                    }
                        
                        
                }
            }
            level++;
        }
        
        return -1;
    }
}