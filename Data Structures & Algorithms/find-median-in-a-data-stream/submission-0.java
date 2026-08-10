class MedianFinder {
    PriorityQueue<Integer> maxPq;
    PriorityQueue<Integer> minPq;

    public MedianFinder() {
        maxPq = new PriorityQueue<>(Collections.reverseOrder());
        minPq = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(maxPq.isEmpty() || num < maxPq.peek()){
            maxPq.add(num);
        } else{
            minPq.add(num);
        }

        if(Math.abs(maxPq.size() - minPq.size()) > 1){
            minPq.add(maxPq.poll());
        }else if(maxPq.size() < minPq.size()){
            maxPq.add(minPq.poll());
        }
    }
    
    public double findMedian() {
        if((maxPq.size() + minPq.size()) % 2 == 0){
            return (maxPq.peek() + minPq.peek()) / 2.0;
        } else{
            return maxPq.peek();
        }
    }
}
