class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> minheap = null;
    PriorityQueue<Integer> maxheap = null;
    
    public MedianFinder() {
        minheap = new PriorityQueue<>(Collections.reverseOrder());
        maxheap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(minheap.isEmpty()) {
            if(maxheap.isEmpty())  maxheap.add(num);    
            else if(num > maxheap.peek()) {                
                minheap.add(maxheap.poll());
                maxheap.add(num);
            } else {
                minheap.add(num);
            }
            return;
        }
        
        int mintop = minheap.peek();
        int maxtop = maxheap.peek();
        if(num < mintop) {
            minheap.add(num);
            if(minheap.size() - maxheap.size() > 1)     maxheap.add(minheap.poll());
        } else if(num > maxtop) {
            maxheap.add(num);
            if(maxheap.size() - minheap.size() > 1)     minheap.add(maxheap.poll());
        } else {
            if(minheap.size() < maxheap.size()) {
                minheap.add(num);
            } else {
                maxheap.add(num);
            }
        }
    }
    
    public double findMedian() {
        if(minheap.size() == maxheap.size())    return (double)(minheap.peek() + maxheap.peek()) / 2;
        else if(minheap.size() > maxheap.size()) {
            return minheap.peek();
        } else {
            return maxheap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */