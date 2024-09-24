class Solution {
    public String minWindow(String s, String t) {
        
        if(s.length()<t.length()){
            return "";
        }
        
        HashMap<Character, Integer> map=new HashMap<>();
        for(char ch: t.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        
        int reqCount=t.length(), minLen=Integer.MAX_VALUE;
        int i=0, j=0, startIdx=0;
        
        while(j<s.length()){
            char ch= s.charAt(j);
            
            if(map.containsKey(ch) && map.get(ch)>0){ // hamko required hai ye character
                reqCount--;
            }
            map.put(ch, map.getOrDefault(ch,0)-1); // hamesha ek se ghatana to hai freq
            
            while(reqCount==0){
                //start shirinking the window

                int currLen=j-i+1;
                if(currLen< minLen){
                    minLen=currLen;
                    startIdx=i; //store the initial index
                }
                
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
                if(map.get(s.charAt(i))>0){
                    reqCount++;
                }
                
                i++;
            }
            j++;  
        }
        
        return minLen==Integer.MAX_VALUE?"": s.substring(startIdx,startIdx+minLen);
    }
}