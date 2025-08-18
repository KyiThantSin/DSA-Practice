package array.pack;

public class MyArray extends MyArrayBasic {
    public MyArray(int capacity){
        super(capacity);
        MAX_SIZE = capacity;
        data = new int[MAX_SIZE]; // override
    }

    public MyArray(){
        super();
        MAX_SIZE = 100000;
        data = new int[MAX_SIZE];
    }

    public boolean isFull(){
        if(size == MAX_SIZE){
            return true;
        }

        return false;
    }

    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        return false;
    }

    public int [] expandByK(int k){
        MAX_SIZE = k * MAX_SIZE;
        return data = new int[MAX_SIZE];
    }

    public int [] expand(){
        MAX_SIZE = MAX_SIZE * 2;
        return data = new int[MAX_SIZE];
    }

    public void insert(int value){
        if(isFull()){
            expand();
        }
        data[size] = value;
        size++;
    }

    public void sorting(){
       for(int i =0; i < size - 1; i++){
        for(int j=0; j < size - 1 - i; j++){
            if(data[j] > data[j+1]){
                int temp = data[j];
                data[j] = data[j+1];
                data[j+1] = temp;
            }
        }
       }
    }

    public int binarySearch(int value){
        sorting();
        int start = 0;
        int end = size - 1;

        while (start <= end){
            int mid = ( start + end) / 2;
            if(data[mid] == value) return mid;
            
            if(value < data[mid]){
                end = mid - 1;
            }else if(value > data[mid]){
                start = mid + 1;
            }
        }
        return -1;
    }

    @Override
    public void delete(int index){
        if(index < 0 || index >= size){
            System.out.println("Invalid index for deletion");
            return;
        }
        super.delete(index);
    }

    @Override
    public void add(int number){
        if(size >= MAX_SIZE){
            System.out.println("FULLED");
            expand();
        }
        super.add(number);
    }

    @Override
    public void insert_unordered(int value, int index){
       if(isFull()){
            expand();
       }
       super.insert_unordered(value, index);
    }
}
