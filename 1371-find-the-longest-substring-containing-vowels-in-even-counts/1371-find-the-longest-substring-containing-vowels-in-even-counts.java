class Solution {
    // https://youtu.be/6Xf5LfM-ciI?si=hKkVagExozofjgL5
    public int findTheLongestSubstring(String s) {
        HashMap<Integer, Integer> map=new HashMap<>(); //O(2^5)-> O(32)
        int mask=0; //000000
        int maxLen=0;    
          
            
        map.put(mask, -1);
        
        for(int i=0;i<s.length();i++){
            char ch= s.charAt(i);
            
            // ^ ->0 means even, 1 means odd 
            if(ch=='a'){             
                mask=(mask^(1<<0)); 
            }else if(ch=='e'){
                mask=(mask^(1<<1));
            }else if(ch=='i'){
                mask=(mask^(1<<2));
            }else if(ch=='o'){
                mask=(mask^(1<<3));
            }else if(ch=='u'){
                mask=(mask^(1<<4));
            }
            
            
            if(map.containsKey(mask)){
                maxLen=Math.max(maxLen, i-map.get(mask));
            }else{
                map.put(mask, i);
            }
            
        }
        
        return maxLen;
    }
}