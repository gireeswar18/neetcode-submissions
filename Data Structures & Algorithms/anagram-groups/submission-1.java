class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] sortedArr = str.toCharArray();
            Arrays.sort(sortedArr);
            String sorted = new String(sortedArr);

            map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(str);
        }

        for (String key : map.keySet()) {
            res.add(map.get(key));
        }

        return res;
    }
}
