package array.pack;

public class MyArrayBasic {
    protected int MAX_SIZE = 5; // instacne variable not local
    protected int size = 0;
    protected int[] data = new int[MAX_SIZE];

    public MyArrayBasic(int ...values){
        if(values.length >= MAX_SIZE){
            MAX_SIZE = values.length;
        }

        data = new int[MAX_SIZE];
        size = Math.min(values.length, MAX_SIZE);

        for(int i=0; i < size; i++){
            data[i] = values[i];
        }
    }

    public void add(int num){
        if(size >= MAX_SIZE){
            System.out.println("Array is Fulled. Please expand");
            return;
        }
        data[size] = num;
        size++;
    }

    public void insert_unordered(int value, int index){
        if(size >= MAX_SIZE){
            System.out.println("Array is Fulled. Please expand");
            return;
        }
        data[size] = data[index];
        data[index] = value;
        size++;
    }

    public int getAt(int index){
        if(index >= size){
            return -1;
        }
        return data[index];
    }

    public void setAt(int index, int value){
        data[index] = value;
    }

    public int find(int value){
        for(int i=0; i < size; i++){
            if(data[i] == value){
                return i;
            }
        }
        return -1;
    }

    public void delete(int index){
        if(index < 0 || index >= size){
            System.out.println("Invalid index");
            return;
        }
        // index 2, size 5 => 4
        for(int i = index; i < size - 1; i++){
            data[i] = data[i+1];
        }
        size--;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i=0; i < size - 1; i++){
            sb.append(data[i]);
            sb.append(", ");
        }
        if(size > 0) sb.append(data[size-1]);
        sb.append("]");
        return sb.toString();
    }


}
