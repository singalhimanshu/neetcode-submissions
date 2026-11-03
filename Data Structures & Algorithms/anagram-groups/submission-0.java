class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        assert strs.length > 0;
        final List<String> sortedStrs = new ArrayList<>();
        final Map<String, List<String>> anagramMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            final String sortedStr = sortStr(strs[i]);
            if (anagramMap.containsKey(sortedStr)) {
                anagramMap.get(sortedStr).add(strs[i]);
            } else {
                final List<String> curAnagramList = new ArrayList<>();
                curAnagramList.add(strs[i]);
                anagramMap.put(sortedStr, curAnagramList);
            }
        }
        final List<List<String>> result = new ArrayList<>();
        anagramMap.forEach((k, v) -> {
            result.add(v);
        });
        return result;
    }

    public String sortStr(String str) {
        if (str == null) {
            return null;
        }
        final char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
    }
}
