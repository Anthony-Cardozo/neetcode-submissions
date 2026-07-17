class MedianFinder {

    PriorityQueue<Integer> q1;
    PriorityQueue<Integer> q2;
    int size;

    public MedianFinder() {
        q1 = new PriorityQueue<>(Collections.reverseOrder());
        q2 = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (size == 0) {
            q2.add(num);
        } else if (size % 2 == 0) {
            if (num >= q2.peek() || num > q1.peek()) {
                q2.add(num);
            } else {
                q2.add(q1.poll());
                q1.add(num);
            }
        } else {
            if ((q1.size() > 0 && num < q1.peek()) || num < q2.peek()) {
                q1.add(num);
            } else {
                q1.add(q2.poll());
                q2.add(num);
            }
        }

        size++;
    }
    
    public double findMedian() {
        if (size == 0) {
            return 0;
        }
        if (size % 2 == 0) {
            return ((double)(q1.peek()) + q2.peek())/2;
        } else {
            return (double)q2.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */