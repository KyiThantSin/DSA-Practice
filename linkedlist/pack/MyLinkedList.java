package linkedlist.pack;

public class MyLinkedList {
    public class Node {
        int data;
        Node next;

        public Node(int d) {
            data = d;
            next = null;
        }
    }

    Node head = null;

    public void add(int d) {
        Node newNode = new Node(d);
        newNode.next = head;
        head = newNode;
    }

    public void add(int[] arr){
        for(int i=arr.length - 1; i >= 0 ; i--){
            add(arr[i]);
        }
    }

    public void insert(int value) {
        Node newNode = new Node(value);

        if (head == null || newNode.data < head.data) {
            newNode.next = head;
            head = newNode;
            return;
        }
        // 5 | 3 -> 6
        Node current = head;
        // If you keep moving head forward in a while loop, you’ll lose the original
        // starting point of the list.
        while (current != null && current.next != null && newNode.data > current.next.data) {
            // current.data is already compared
            current = current.next;
        }
        // current is at 3
        newNode.next = current.next;
        current.next = newNode;
    }

    public void insert(int[] arr){
        for(int i=arr.length - 1; i >= 0; i--){
            insert(arr[i]);
        }
    }

    public int getAt(int index){
        Node current = head;
        while( current != null && index > 0){
            current = current.next;
            index--;
        }

        if (current == null) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
    
        return current.data;
    }
    
    public void setAt(int index, int d){
        Node current = head;
    
        while(current != null && index > 0){
            current = current.next;
            index--;
        }

        if (current == null) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }

        current.data = d;
    }

    public int size() {
        if (head == null) {
            return 0;
        }
        Node current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void delete(int value) {
        if (head == null) {
            return;
        }

        if (head.data == value) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data == value) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public int find(int value){
        if(head == null){
            return -1;
        }

        Node current = head;
        int count = 0;
        while(current != null){
            if(current.data == value){
                return count;
            }
            count++;
            current = current.next;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("head ");
        Node current = head;
        while (current != null) {
            sb.append(" -> [ ");
            sb.append(current.data);
            sb.append("]");
            current = current.next;
        }

        if (current == null) {
            sb.append("-> null");
        }
        return sb.toString();
    }
}
