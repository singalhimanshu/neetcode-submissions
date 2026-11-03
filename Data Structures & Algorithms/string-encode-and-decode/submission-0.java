class Solution {
    public String encode(List<String> strs) {
        final StringBuilder sb = new StringBuilder();
        for (String str: strs) {
            sb.append(String.valueOf(str.length())).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        final List<String> decodedStrs = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') j++;
            int length = Integer.valueOf(str.substring(i, j));
            i = j + 1 + length;
            decodedStrs.add(str.substring(j + 1, i));
        }
        return decodedStrs;
    }
}
