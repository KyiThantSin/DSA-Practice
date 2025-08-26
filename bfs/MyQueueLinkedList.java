package bfs;

public class MyQueueLinkedList {
    public class Node{
        int data;
        Node next;

        public Node(int d){
            data = d;
        }
    }
    
    Node head = null;
    Node tail = null;

    public void enqueue(int d){
        Node newNode = new Node(d);
        if(head == null){
            head=newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = tail.next;
        }
    }

    public int dequeue(){
        if(head == null){
            return 0;
        }
        int d = head.data;
        head = head.next;
        return d;
    }

    public int size(){
        if(head == null){
            return 0;
        }
        Node current = head;
        int count = 0;
        while(current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    public int getFront(){
        return head.data;
    }

    public boolean isFull(){
        return false;
    }

    public boolean isEmpty(){
        return head == null;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node current = head;
        sb.append("head");
        while(current != null){
            sb.append("-> [");
            sb.append(current.data);
            sb.append("]");
            current = current.next;
        }
        if(current == null){
            sb.append(" -> null");
        }

        return sb.toString();

    }

    public static void main(String args[]){
        MyQueueLinkedList queue = new MyQueueLinkedList();
        queue.enqueue(5);
        queue.enqueue(6);
        System.out.println(queue.toString());
    }
}
