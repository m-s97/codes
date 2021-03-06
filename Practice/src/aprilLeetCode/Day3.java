package aprilLeetCode;

import java.util.Stack;

/*
 * https://leetcode.com/explore/challenge/card/
 * april-leetcoding-challenge-2021/593/week-1-april-1st-april-7th/3695/
 * 
 * Longest valid Parenthesis
 */
public class Day3 {
	// Using Stack Approach O(N) time/space
    public int solveStack(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int max = 0;
        for(int i=0;i<s.length();i++){
            char x = s.charAt(i);
            if(x == '('){
                st.push(i);
            }
            else{
                st.pop();
                if(st.isEmpty()) st.push(i);
                else{
                    max = Math.max(max,i-st.peek());
                }
            }
        }
        return max;
    }
    // O(N) time contant space
    public int solve(String s) {
        int left =0,right =0,max=0;
        for(int i=0;i<s.length();i++){
            char x = s.charAt(i);
            if(x == '(') left++;
            else right++;
            
            if(left == right) max = Math.max(max,right*2);
            if(left < right) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return max;
    }
}
