class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        for(int h : hand){
            mp.put(h, mp.getOrDefault(h, 0) + 1);
        }

        if(hand.length % groupSize != 0){
            return false;
        }

        while(!mp.isEmpty()){
            int key = mp.firstKey();

            for(int i = 0; i < groupSize; i++){
                int value = key + i;

                if(!mp.containsKey(value)){
                    return false;
                }

                mp.put(value, mp.get(value) - 1);
                if(mp.get(value) == 0){
                    mp.remove(value);
                }
            }
        }
        return true;
    }
}
