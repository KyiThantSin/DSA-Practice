package recursion;

import java.util.ArrayList;

public class permutation {
    public static void permutationFunction(int[] arr, boolean[] used, int level, ArrayList<Integer> ele,
            ArrayList<ArrayList<Integer>> lis) {
            
            if(arr.length == level){
                lis.add(new ArrayList<>(ele)); // need to copy to avoid duplicate in backtrack
                return;
            }
            for(int i=0; i < arr.length; i++){
                if(used[i] == false){
                    used[i] = true; // [T, F, F] 
                    ele.add(arr[i]); // [1]
                    // Generates [1,2,3] and [1,3,2]
                    permutationFunction(arr, used, level + 1, ele, lis );
                    ele.remove(ele.size()-1);
                    used[i] = false; // [F, F, F]
                }
            }
    }

    public static void main(String args[]) {
        int[] arr = { 1, 2, 3 };
        boolean[] used = new boolean[arr.length];
        ArrayList<ArrayList<Integer>> lis = new ArrayList<>();

        permutationFunction(arr, used, 0, new ArrayList<>(), lis);

        for (ArrayList<Integer> ele : lis) {
            System.out.println(ele);
        }

    }
}
