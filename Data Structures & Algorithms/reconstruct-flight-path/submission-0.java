class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> mp = new HashMap<>();
        List<String> result = new ArrayList<>();

        for(List<String> t: tickets){
            String from = t.get(0);
            String to = t.get(1);
            mp.computeIfAbsent(from , x -> new PriorityQueue<>()).add(to);
        }

        dfs("JFK", mp, result);
        Collections.reverse(result);
        return result;
    }

    public void dfs(String source, Map<String, PriorityQueue<String>> mp, List<String> result ){
        PriorityQueue<String> pq = mp.getOrDefault(source, new PriorityQueue<>());

        while(!pq.isEmpty()){
            String destination = pq.poll();
            dfs(destination, mp, result);
        }
        result.add(source);
    }
}
