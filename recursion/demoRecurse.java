package recursion;

public class demoRecurse {
    public static void recurse(int[] arr, int depth){
        if(arr.length == depth){
            return;
        }
        recurse(arr, depth + 1);
        System.out.println(arr[depth]);
    }

    public static void main(String args[]){
        int[] arr = {1,4,9};
        recurse(arr,0);
    }
}