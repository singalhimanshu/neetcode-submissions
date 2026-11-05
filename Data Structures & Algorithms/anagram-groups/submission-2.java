class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            map.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
        }
        List<List<String>> res = new ArrayList<>();
        for (var entry: map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
}
