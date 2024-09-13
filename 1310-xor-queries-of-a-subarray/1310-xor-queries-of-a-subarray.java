class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int length=arr.length;
        int[] prefixXOR=new int[length];
        prefixXOR[0] =arr[0];
        for (int idx=1;idx<length; idx++) {
            prefixXOR[idx]=prefixXOR[idx-1]^arr[idx];
        }

        int[] result=new int[queries.length];

        for (int queryIdx =0;queryIdx<queries.length;queryIdx++) {
            int start=queries[queryIdx][0];
            int end=queries[queryIdx][1];

            if (start==0) {
                result[queryIdx]=prefixXOR[end];
            } else {
                result[queryIdx]= prefixXOR[end]^prefixXOR[start-1];
            }
        }
        return result;

    }
}