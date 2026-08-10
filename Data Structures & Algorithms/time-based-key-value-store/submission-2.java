class TimeMap {
    public class TimePair{
        String value;
        int timestamp;

        public TimePair(String value, int t) {
        this.value = value;
        this.timestamp = t;
        }
    } 
    Map<String, List<TimePair>> mp;
    public TimeMap() {
        mp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!mp.containsKey(key)){
            mp.put(key, new ArrayList<>());
        }
        mp.get(key).add(new TimePair(value , timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!mp.containsKey(key)){
            return "";
        }

        List<TimePair> timeList = mp.get(key);
        Optional<TimePair> pp = binarySearch(timeList,  timestamp);
        if(pp.isEmpty()){
            return "";
        }
        return pp.get().value;
    }

    public Optional<TimePair> binarySearch(List<TimePair> nums, int target){
        int l = 0;
        int r = nums.size() - 1;
        int idx = -1;

        while(l <= r){
            int mid = l + (r - l) / 2;

            if(nums.get(mid).timestamp <= target){
                idx = mid;
                 l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        if(idx == -1){
            return Optional.empty();
        } else{
            return Optional.of(nums.get(idx));
        }
    }
}
