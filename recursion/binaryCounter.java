package recursion;

import java.util.ArrayList;

public class binaryCounter {
    public static void binaryCounterFunction(int n) {
        ArrayList<String> list = new ArrayList<String>();
        binaryCounterFunction(n, 0, new StringBuilder(), list);
        System.out.println(list);
    }

    public static void binaryCounterFunction(int n, int level, StringBuilder sb, ArrayList<String> list) {
        if (level == n) {
            list.add(sb.toString());
            return;
        }
        // n = 2, level = 0, sb = ""
        // sb.append('0') → sb = "0"
        // call level 1

        // n = 2, level = 1, sb = "0"
        // sb.append('0') → sb = "00"
        // call level 2

        // n = 2, level = 2 → return
        // back to level 1
        // sb.deleteCharAt() → sb = "0" ✓

        // sb.append('1') → sb = "01"
        // call level 2 again

        // n = 2, level = 2 → return
        // back to level 1
        // sb.deleteCharAt() → sb = "0" ✓
        // level 1 returns to level 0

        // back to level 0
        // sb.deleteCharAt() → sb = "" ✓

        // Each recursive call "pauses" the current function until it returns then continue to append ("1")
        sb.append("0");
        binaryCounterFunction(n, level + 1, sb, list);
        sb.deleteCharAt(sb.length() - 1);

        sb.append("1");
        binaryCounterFunction(n, level + 1, sb, list);
        sb.deleteCharAt(sb.length() - 1);

        // END OF FUNCTION - No more code to execute!
        // Java automatically returns here (implicit return)
        //back to sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String args[]) {
        binaryCounterFunction(3);
    }
}
