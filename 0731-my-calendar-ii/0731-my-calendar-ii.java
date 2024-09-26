class MyCalendarTwo {
    
    Map<Integer, Integer> map;
    public MyCalendarTwo() {
        map=new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start,0)+1);
        map.put(end, map.getOrDefault(end,0)-1);
        
        int count=0;
        for(int val:map.values()){
            count+=val;
            
            if(count>=3){
                //undo the changes, triplet found
                map.put(start, map.getOrDefault(start,0)-1);
                map.put(end, map.getOrDefault(end,0)+1);
                return false;
            }
        }
        
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */