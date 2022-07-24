class Solution {
    //O(N)
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int s=-1;
        int e=-1;
        int res=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=left && nums[i]<=right){
                e=i;
            }else if(nums[i]>right){
                e=s=i;
            }else{
                //lessar than left
            }
            res+=(e-s);
        }
        return res;
    }
}