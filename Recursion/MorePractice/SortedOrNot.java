package Recursion.MorePractice;

public class SortedOrNot {
    /*
    Check if Array Is Sorted
[1, 2, 4, 7, 9] → true
[1, 3, 2, 7]    → false

No loops.
But here's the challenge:
Can you solve it by comparing the current element only with information from the recursive call?
     */
    public static void main(String[] args) {
int[] arr = {10,1};
        System.out.println(isSorted(arr,0));

    }

    static boolean isSorted(int[] arr,int index){
        if(index == arr.length){
            return true;
        }

        if(index > 0){
            if(arr[index] < arr[index -1]){
                return false;
            }
        }
        return true && isSorted(arr,index+1);

    }
}
