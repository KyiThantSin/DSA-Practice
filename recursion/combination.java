package recursion;

public class combination {
    public static void combinationFunction(int[] arr){
        combinationFunction(arr, "", 0);
    }

    public static void combinationFunction(int[] arr, String sb, int level){
        if(arr.length == level){
            System.out.println(sb);
            return;
        }

        combinationFunction(arr, sb, level+1);
        // we left off here
        String pick = sb + arr[level];
        combinationFunction(arr, pick, level+1);
        // LEVEL 0 reaches end of function → done! so it continue where we left off
    }
    public static void main(String args[]){
        int[] arr = {2,3,1};
        combinationFunction(arr);
    }
}
