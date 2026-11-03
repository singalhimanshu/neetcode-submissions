class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        assert strs != null;

        final Map<String, List<String>> anagramMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            final String str = strs[i];
            char[] freqMap = new char[26];
            for (char c: str.toCharArray()) {
                freqMap[c - 'a']++;
            }
            final String freqMapStr = String.valueOf(freqMap);
            if (!anagramMap.containsKey(freqMapStr)) {
                anagramMap.put(freqMapStr, new ArrayList<>());
            }
            anagramMap.get(freqMapStr).add(strs[i]);
        }
        final List<List<String>> result = new ArrayList<>();
        assert anagramMap != null;
        anagramMap.forEach((k, v) -> {
            result.add(v);
        });
        return result;
    }
}
