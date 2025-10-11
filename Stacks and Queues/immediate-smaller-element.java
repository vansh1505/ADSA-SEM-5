import java.util.ArrayList;
import java.util.Stack;
class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        // code here
        int[] ans = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        for(int i = arr.length - 1; i >= 0; i--){
            while(!s.isEmpty() && s.peek() >= arr[i]){
                s.pop();
            }
            
            if (s.isEmpty()) ans[i] = -1;
            else ans[i] = s.peek();
            
            s.push(arr[i]);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : ans) list.add(i);
        return list;
    }
}