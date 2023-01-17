class Solution {
    public int maxSum(int[][] grid) {
        int max=Integer.MIN_VALUE;
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m-2;i++){
            for(int j=0;j<n-2;j++){
                int sum = grid[i][j] + grid[i][j+1] + grid[i][j+2] + grid[i+1][j+1] 
                + grid[i+2][j] + grid[i+2][j+1] + grid[i+2][j+2];
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
