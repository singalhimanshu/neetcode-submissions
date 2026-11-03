class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stk.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stk.isEmpty()) {
                    return false;
                }
                char open = stk.pop();
                if (open == '(' && c != ')') {
                    return false;
                }
                if (open == '[' && c != ']') {
                    return false;
                }
                if (open == '{' && c != '}') {
                    return false;
                }
            }
        }
        return stk.isEmpty();
    }
}
