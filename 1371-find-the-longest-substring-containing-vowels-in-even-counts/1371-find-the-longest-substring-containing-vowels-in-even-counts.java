class Solution {
    public int findTheLongestSubstring(String s) {
        HashMap<String, Integer> map=new HashMap<>();
        String currState="00000"; //aeiou
        int maxLen=0;    
        int[] state=new int[5];    
            
        map.put(currState, -1);
        
        for(int i=0;i<s.length();i++){
            char ch= s.charAt(i);
            
            if(ch=='a'){
                state[0]=(state[0]+1)%2;
            }else if(ch=='e'){
                state[1]=(state[1]+1)%2;
            }else if(ch=='i'){
                state[2]=(state[2]+1)%2;
            }else if(ch=='o'){
                state[3]=(state[3]+1)%2;
            }else if(ch=='u'){
                state[4]=(state[4]+1)%2;
            }
            
            
            currState="";
            for(int j=0;j<5;j++){
                currState+=state[j];
            }
            
            
            if(map.containsKey(currState)){
                maxLen=Math.max(maxLen, i-map.get(currState));
            }else{
                map.put(currState, i);
            }
            
        }
        
        return maxLen;
    }
}