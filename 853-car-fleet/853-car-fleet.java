class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer,Integer> map=new TreeMap<>(Collections.reverseOrder());
        for(int i=0;i<position.length;i++){
            map.put(position[i],speed[i]);
        }
        
        double time=0;
        int res=0;
        for(Map.Entry<Integer,Integer> car:map.entrySet()){
            double ctime=(target-car.getKey())*1.0/car.getValue();
            if(ctime>time){
                time=ctime;
                res++;
            }
        }
        return res;
    }
}