class myQueue {
    int front;
    int rear;
    int arr[];
    
    // Constructor
    public myQueue(int n) {
        // Define Data Structures
        arr = new int[n];
        front = -1;
        rear = -1;
    }

    public boolean isEmpty() {
        // Check if queue is empty
        return front == -1;
    }

    public boolean isFull() {
        // Check if queue is full
        if (isEmpty()) return false;
        return (rear - front + 1) == arr.length;
    }

    public void enqueue(int x) {
        // Enqueue
        if(isFull()) return;
        if(isEmpty()){
            front = 0;
        }
        rear++;
        arr[rear] = x;
    }

    public void dequeue() {
        // Dequeue
        if (isEmpty()) return;
        if (front == rear) {
            front = rear = -1;
        } else {
            front++;
        }
    }

    public int getFront() {
        // Get front element
        if (isEmpty()) return -1;
        return arr[front];
    }

    public int getRear() {
        // Get last element
        if (isEmpty()) return -1;
        return arr[rear];
    }
}
