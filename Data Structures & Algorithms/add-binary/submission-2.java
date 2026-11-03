class Solution {
    public String addBinary(String a, String b) {
        int n1 = a.length();
        int n2 = b.length();
        int i = n1 - 1, j = n2 - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int a1 = a.charAt(i) - '0';
            int b1 = b.charAt(j) - '0';
            int sum = a1 + b1 + carry;
            if (sum == 0) {
                sb.append('0');
            } else if (sum == 1) {
                sb.append('1');
                carry = 0;
            } else if (sum == 2) {
                sb.append('0');
                carry = 1;
            } else {
                carry = 1;
                sb.append('1');
            }
            // System.out.println("sum: " + sum + " carry: " + carry + " sb: " + sb.toString());
            i--;
            j--;
        }
        while (i >= 0) {
            int a1 = a.charAt(i--) - '0';
            int sum = a1 + carry;
            if (sum == 0) {
                sb.append('0');
            } else if (sum == 1) {
                sb.append('1');
                carry = 0;
            } else if (sum == 2) {
                sb.append('0');
                carry = 1;
            }
            // System.out.println("[i] sum: " + sum + " carry: " + carry + " sb: " + sb.toString());
        }
        while (j >= 0) {
            int b1 = b.charAt(j--) - '0';
            int sum = b1 + carry;
            if (sum == 0) {
                sb.append('0');
            } else if (sum == 1) {
                sb.append('1');
                carry = 0;
            } else if (sum == 2) {
                sb.append('0');
                carry = 1;
            }
        }
        // System.out.println("carry: " + carry);
        if (carry == 1) sb.append('1');
        return sb.reverse().toString();
    }
}