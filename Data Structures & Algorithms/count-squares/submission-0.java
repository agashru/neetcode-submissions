class CountSquares {
    Map<Integer, Map<Integer, Integer>> mp;

    public CountSquares() {
        mp = new HashMap<>();
    }
    
    public void add(int[] point) {
        int x1 = point[0];
        int y1 = point[1];

        mp.putIfAbsent(x1, new HashMap<>());
        mp.get(x1).put(y1, mp.get(x1).getOrDefault(y1, 0) + 1);
    }
    
    public int count(int[] point) {
        int x1 = point[0];
        int y1 = point[1];

        if(!mp.containsKey(x1)) {
            return 0;
        }

        int total = 0;

        for(Map.Entry<Integer,Integer> entry : mp.get(x1).entrySet()){
            int y2 = entry.getKey();
            int count = entry.getValue();

            if(y1 == y2){
                continue;
            }

            int length = Math.abs(y1 - y2);
            total += countSquares(x1, y1, x1 + length , y2 , count);
            total += countSquares(x1, y1, x1 - length , y2, count);
        }
        return total;
    }

    public int countSquares(int x1, int y1, int x2, int y2,  int count){
        if(mp.containsKey(x2)){
            Map<Integer, Integer> p = mp.get(x2);
            return p.getOrDefault(y1, 0) * p.getOrDefault(y2, 0) * count;
        }
        return 0;
    }
}
