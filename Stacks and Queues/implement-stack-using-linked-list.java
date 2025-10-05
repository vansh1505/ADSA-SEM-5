// Node class
class Node {
    int data;
    Node next;

    Node(int new_data) {
        data = new_data;
        next = null;
    }
}

// Stack class
class myStack {
    Node head;
    public myStack() {
        // Initialize your data members
        head = null;
        
    }

    public boolean isEmpty() {
        // check if the queue is empty
        return head == null;
    }

    public void push(int x) {
        // Adds an element x at the rear of the queue.
        Node newNode = new Node(x);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void pop() {
        // Removes the front element of the queue
        if(head == null){
            return;
        }
        head = head.next;
    }

    public int peek() {
        // Returns the front element of the queue.
        // If queue is empty, return -1.
        if(head == null){
            return -1;
        }
        return head.data;
    }

    public int size() {
        // Returns the current size of the queue.
        if(head == null){
            return 0;
        }
        Node currNode = head;
        int c = 0;
        while(currNode != null){
            currNode = currNode.next;
            c++;
        }
        return c;
    }
}