class Solution {
    public int calPoints(String[] operations) {
        int n = operations.length;
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < n; i++) {
            String op = operations[i];
            if (op.equalsIgnoreCase("+")) {
                int s1 = stk.pop();
                int s2 = stk.pop();
                stk.push(s2);
                stk.push(s1);
                stk.push(s1 + s2);
            } else if (op.equalsIgnoreCase("C")) {
                stk.pop();
            } else if (op.equalsIgnoreCase("D")) {
                int s1 = stk.pop();
                stk.push(s1);
                stk.push(s1 * 2);
            } else {
                stk.push(Integer.parseInt(op));
            }
        }
        int res = 0;
        while (!stk.isEmpty()) {
            res += stk.pop();
        }
        return res;
    }
}