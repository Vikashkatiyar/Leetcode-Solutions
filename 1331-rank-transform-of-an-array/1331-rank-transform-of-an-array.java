class Solution {
    public int[] arrayRankTransform(int[] arr) {
        
        int[] copyArr=Arrays.copyOf(arr, arr.length);
        Arrays.sort(copyArr);
        HashMap<Integer, Integer> map=new HashMap<>();
        
        int val=1;
        for(int ele: copyArr){
            if(!map.containsKey(ele)){
                map.put(ele, val++);
            }
        }
        
        int[] ans=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            ans[i]=map.get(arr[i]);
        }
        
        return ans;
    }
}