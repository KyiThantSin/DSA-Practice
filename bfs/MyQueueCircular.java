package bfs;

public class MyQueueCircular {
   private int[] queue;
   private int size = 0;
   private int head = 0;
   private int tail = 0;
   private int max_size = 0;

   public MyQueueCircular(int capacity){
        max_size = capacity;
        queue = new int[max_size];
        head = 0;
        tail = 0;
        size = 0;
   }

   public void enqueue(int num){
       queue[tail] = num;
       tail = (tail + 1) % max_size;
       size++;
   }

   public int dequeue(){
        if(isEmpty()){
            return -1;
        }
        int d = queue[head];
        head = (head + 1) % max_size;
        size--;
        return d;
   }

   public int getSize(){
        return size;
   }

   public boolean isEmpty(){
        return size == 0;
   }

   public boolean isFull(){
        return size == max_size;
   }

   @Override
   public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for(int i=0; i < size - 1; i++){
            sb.append(queue[i] + " , ");
        }
        if( size > 0){
            sb.append(queue[size-1]);
            sb.append("]");
        }
        return sb.toString();
   }
}
