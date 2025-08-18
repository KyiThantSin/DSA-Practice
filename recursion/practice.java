package recursion;

public class practice {
    public static int factorial(int num){
        // smallest case = 0; 
        if(num == 0) return 1;
        return num * factorial(num - 1);
    }

    public static int Fibonacci(int num){
        // smallest base case -> 0, 1
        // since formula is (n-1)+(n-2)

        if(num == 0) return 0;
        if(num == 1) return 1;

        return Fibonacci(num - 1) + Fibonacci(num - 2);
    }

    public static int sum(int num){
        // smallest base case -> 0
        if(num == 0) return 0;
        return num + sum(num - 1);
    }

    public static String reverseString(String str, int len){
        // hello // smallest case no value;
        if(len < 0) return "";
        return str.charAt(len) + reverseString(str, len - 1);        
    }

    public static int powerNumber(int num, int pow){
        // smallest -> num 0 , pow 0
        if(pow == 0) return 1;
        // return num ( first parts )
        return num * powerNumber(num, pow - 1);
    }

    public static int countOccurrences(int[] arr, int target, int index){
        if(index < 0) return 0;

        // [2,3,4,5,5]
        int count = 0;
        if(target == arr[index]){
            count = 1;
        }
        return count + countOccurrences(arr, target, index - 1);
    }

    public static void main(String args[]){
        System.out.println("Factorial");
        System.out.println(factorial(5));

        System.out.println("Fibonacci");
        System.out.println(Fibonacci(6));

        System.out.println("Sum of Digit");
        System.out.println(sum(4));

        System.out.println("Reverse String");
        String a = "hello";
        System.out.println(reverseString(a, a.length() - 1));

        System.out.println("Power of Number ");
        System.out.println(powerNumber(2, 4));

        System.out.println("Count Occourance ");
        int[] arr = {2,3,2,5,6,2};
        System.out.println(countOccurrences(arr, 2, arr.length - 1));
    }
}
