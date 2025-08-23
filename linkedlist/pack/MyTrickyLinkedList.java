package linkedlist.pack;

public class MyTrickyLinkedList extends MyLinkedList {
    public void insert(int data){
        Node newNode = new Node(data);

        if(head == null || data < head.data){
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        while(current != null && newNode.data > current.next.data ){
            current = current.next;
        }
        
       newNode.next = current.next;
       current.next = newNode;
    }

    public void insert(int[] arr){
        for(int i = arr.length - 1; i >= 0; i--){
            insert(arr[i]);
        } 
    }

    public void q1_rotate_clockwise(int k){
        int n = size();

        if (head == null || k <= 0 || n <= 1) {
            return;
        }

        //size n = 5, k = 7, 7 % 5 = 2 → rotating by 7 is the same as rotating by 2
        k = k % n;
        if (k == 0) {
            return;
        }

        Node newTail = head;
        for (int i = 1; i < n - k; i++) {
            newTail = newTail.next;
        }

        Node newHead = newTail.next;

        newTail.next = null;

        Node currentTail = newHead;
        while (currentTail.next != null) {
            currentTail = currentTail.next;
        }

        currentTail.next = head;

        head = newHead;
    }

}
