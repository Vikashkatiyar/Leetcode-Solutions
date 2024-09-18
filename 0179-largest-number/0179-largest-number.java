class Solution {
    public String largestNumber(int[] nums) {
        String []sarr=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            sarr[i]=nums[i]+"";
        }
        
        
        Arrays.sort(sarr,(a,b)->{
            String case1=a+b;
            String case2=b+a;
            return case2.compareTo(case1);
        });
        
        if(sarr[0].equals("0")) //if sarr is full with all zeros
            return "0";
        
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<sarr.length;i++){
            sb.append(sarr[i]);
        }
        return sb.toString();
    }
}