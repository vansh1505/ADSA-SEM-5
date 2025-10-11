import java.util.ArrayList;
import java.util.Stack;
class Solution {
    public static ArrayList<Integer> prevSmaller(int[] arr) {
        // code here
        Stack<Integer> s = new Stack<>();
        int ans[] = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            while(!s.isEmpty() && s.peek() >= arr[i]){
                s.pop();
            }
            
            if(s.isEmpty()){
                ans[i] = -1;
            } else {
                ans[i] = s.peek();
            }
            s.push(arr[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : ans) list.add(i);
        return list;
    }
}